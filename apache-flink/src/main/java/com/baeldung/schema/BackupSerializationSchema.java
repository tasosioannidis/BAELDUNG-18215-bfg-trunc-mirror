package com.baeldung.schema;

import com.baeldung.model.Backup;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackupSerializationSchema
  implements SerializationSchema<Backup> {

    ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(BackupSerializationSchema.class);

    @Override
    public byte[] serialize(Backup backupMessage) {
        if(objectMapper == null) {
            objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        }
        try {
            String json = objectMapper.writeValueAsString(backupMessage);
            return json.getBytes();
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            logger.error("Failed to parse JSON", e);
        }
        return new byte[0];
    }
}
