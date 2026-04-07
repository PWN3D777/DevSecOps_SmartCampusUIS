package com.smartuis.messages.service;

import java.util.List;

import com.smartuis.messages.dto.DeviceMessageDetail;

public interface DeviceMessageService {

     /**
     * 
     * Return device messages
     * @return {@link DeviceMesssageDetail}
     */
    List<DeviceMessageDetail> findByDeviceUUID(String uuid);
    
}
