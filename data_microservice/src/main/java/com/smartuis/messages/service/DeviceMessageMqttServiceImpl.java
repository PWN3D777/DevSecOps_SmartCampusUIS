package com.smartuis.messages.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.smartuis.messages.documents.DeviceMessage;
import com.smartuis.messages.repository.DeviceMessageRepository;

@Service
public class DeviceMessageMqttServiceImpl implements DeviceMessageMqttService {

    @Autowired
    private DeviceMessageRepository repository;

    @Override
    public Boolean saveMqttDeviceMessage(Message<?> message){  
        try{
            Gson g = new Gson();
            DeviceMessage message_obj = g.fromJson(message.getPayload().toString(), DeviceMessage.class);      
            repository.save(message_obj);
            return true;
        } 
        catch(Exception e){
            System.out.println(e);            
        }
        return false;  
        
    }
    
}
