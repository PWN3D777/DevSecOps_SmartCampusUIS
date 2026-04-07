package com.smartuis.messages.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.smartuis.messages.documents.DeviceMessage;


public interface DeviceMessageRepository extends MongoRepository<DeviceMessage, String> {

    public List<DeviceMessage> findBydeviceUUID(String deviceUUID);

    public List<DeviceMessage> findBytopic(String topic);
    
}

