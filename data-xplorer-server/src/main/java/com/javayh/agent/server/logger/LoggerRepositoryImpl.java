package com.javayh.agent.server.logger;

import com.javayh.agent.common.bean.proto.LoggerCollectorProto;
import com.javayh.agent.common.configuration.DataXplorerProperties;
import com.javayh.agent.common.executor.OutboundExecutor;
import com.javayh.agent.common.listener.OutboundCacheQueue;
import com.javayh.agent.common.repository.LoggerRepository;
import com.javayh.agent.server.listener.OutboundQueueListener;
import com.javayh.agent.server.logger.entity.DataXplorerLoggerEntity;
import com.javayh.agent.server.logger.service.DataXplorerLoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-09-23
 */
@Slf4j
@Primary
@Service
public class LoggerRepositoryImpl implements LoggerRepository<LoggerCollectorProto.LoggerCollector> {

    private final DataXplorerLoggerService dataXplorerLoggerService;

    private final DataXplorerProperties dataXplorerProperties;

    public LoggerRepositoryImpl(DataXplorerLoggerService dataXplorerLoggerService, DataXplorerProperties dataXplorerProperties) {
        DataXplorerProperties.OutboundTransferRate outboundTransferRate = dataXplorerProperties.getOutboundTransferRate();
        Integer initialDelay = outboundTransferRate.getInitialDelay();
        Integer period = outboundTransferRate.getPeriod();
        Integer dataThroughput = outboundTransferRate.getDataThroughput();
        // 设置定时任务，每隔一定时间执行批量插入
        ScheduledExecutorService singe = OutboundExecutor.singe();
        singe.scheduleAtFixedRate(new OutboundQueueListener<DataXplorerLoggerEntity>(
                        OutboundCacheQueue.OUTBOUND_CACHE, dataThroughput, dataXplorerLoggerService),
                initialDelay, period, TimeUnit.SECONDS);
        this.dataXplorerLoggerService = dataXplorerLoggerService;
        this.dataXplorerProperties = dataXplorerProperties;
    }

    /**
     * 单条数据存储
     *
     * @param data 原始数据
     */
    @Override
    public void save(LoggerCollectorProto.LoggerCollector data) {
        if (!data.getIgnore()) {
            DataXplorerLoggerEntity dataXplorerLoggerEntity = new DataXplorerLoggerEntity();
            dataXplorerLoggerEntity.copy(data);
            OutboundCacheQueue.OUTBOUND_CACHE.offer(dataXplorerLoggerEntity);
            Integer dataThroughput = dataXplorerProperties.getOutboundTransferRate().getDataThroughput();
            if (OutboundCacheQueue.OUTBOUND_CACHE.size() >= dataThroughput) {
                new OutboundQueueListener<DataXplorerLoggerEntity>(OutboundCacheQueue.OUTBOUND_CACHE, dataThroughput, dataXplorerLoggerService);
            }
        }
    }

    /**
     * 单条数据存储
     *
     * @param data 原始数据集
     */
    @Override
    public void batchSave(List<LoggerCollectorProto.LoggerCollector> data) {

    }
}
