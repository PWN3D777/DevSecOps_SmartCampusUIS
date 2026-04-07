package com.smartuis.messages.dto;


import java.util.Map;

import com.smartuis.messages.documents.DeviceMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceMessageDetail {

     /*Identificador unico del dispositivo */
     private String deviceUUID;

     /*Topico del mensaje */
     private String topic;
 
     /*Fecha de Creación del Mensaje */
     private String timeStamp;
 
     /*Mensaje*/
     private Map<String,Object> values;
 
     /*Estado del Dispositivo (opcional)*/
     private String status;
     
     /*Indica si el mensaje es una alerta (opcional)*/
     private Boolean alert;
 
     public void setEntity(DeviceMessage message){
         deviceUUID = message.getDeviceUUID();
         topic = message.getTopic();
         timeStamp = message.getTimeStamp();
         values = message.getValues();
         status = message.getStatus();
         alert = message.getAlert();
     }
    
}
