// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageType.proto

package com.javayh.agent.common.bean.proto;

public final class MessageTypeProto {
    private MessageTypeProto() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    /**
     * Protobuf enum {@code com.javayh.agent.rpc.MessageType}
     */
    public enum MessageType
            implements com.google.protobuf.ProtocolMessageEnum {
        /**
         * <code>LOGGER_COLLECTOR = 0;</code>
         */
        LOGGER_COLLECTOR(0),
        /**
         * <code>MESSAGE_BODY = 1;</code>
         */
        MESSAGE_BODY(1),
        UNRECOGNIZED(-1),
        ;

        /**
         * <code>LOGGER_COLLECTOR = 0;</code>
         */
        public static final int LOGGER_COLLECTOR_VALUE = 0;
        /**
         * <code>MESSAGE_BODY = 1;</code>
         */
        public static final int MESSAGE_BODY_VALUE = 1;


        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new java.lang.IllegalArgumentException(
                        "Can't get the number of an unknown enum value.");
            }
            return value;
        }

        /**
         * @param value The numeric wire value of the corresponding enum entry.
         * @return The enum associated with the given numeric wire value.
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @java.lang.Deprecated
        public static MessageType valueOf(int value) {
            return forNumber(value);
        }

        /**
         * @param value The numeric wire value of the corresponding enum entry.
         * @return The enum associated with the given numeric wire value.
         */
        public static MessageType forNumber(int value) {
            switch (value) {
                case 0:
                    return LOGGER_COLLECTOR;
                case 1:
                    return MESSAGE_BODY;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
        internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<
                MessageType> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
                    public MessageType findValueByNumber(int number) {
                        return MessageType.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
            if (this == UNRECOGNIZED) {
                throw new java.lang.IllegalStateException(
                        "Can't get the descriptor of an unrecognized enum value.");
            }
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
            return MessageTypeProto.getDescriptor().getEnumTypes().get(0);
        }

        private static final MessageType[] VALUES = values();

        public static MessageType valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new java.lang.IllegalArgumentException(
                        "EnumValueDescriptor is not for this type.");
            }
            if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private MessageType(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:com.javayh.agent.rpc.MessageType)
    }


    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\021MessageType.proto\022\024com.javayh.agent.rp" +
                        "c*5\n\013MessageType\022\024\n\020LOGGER_COLLECTOR\020\000\022\020" +
                        "\n\014MESSAGE_BODY\020\001B\022B\020MessageTypeProtob\006pr" +
                        "oto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
