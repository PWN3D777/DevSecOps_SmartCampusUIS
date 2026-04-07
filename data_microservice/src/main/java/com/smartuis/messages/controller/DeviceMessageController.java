package com.smartuis.messages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartuis.messages.service.DeviceMessageService;
import com.smartuis.messages.dto.DeviceMessageDetail;

@RestController
@RequestMapping("device")
public class DeviceMessageController {

    @Autowired
    private DeviceMessageService service;


    @GetMapping
    public List<DeviceMessageDetail> deviceMessage(@RequestParam String uuid){
        return service.findByDeviceUUID(uuid);
    }
}
