package com.smartuis.messages.service;

import org.springframework.messaging.Message;

public interface DeviceMessageMqttService {
    
     /**
     * 
     * Return device messages
     * @return {@link DeviceMesssageDetail}
     */
    Boolean saveMqttDeviceMessage(Message<?> message);

}
