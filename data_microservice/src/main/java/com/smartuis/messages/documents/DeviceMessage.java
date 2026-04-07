package com.smartuis.messages.documents;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "messages")
public class DeviceMessage {

    /*Identificador del mensaje */
    public String id;

    /*Identificador unico del dispositivo */
    public String deviceUUID;

    /*Topico del mensaje */
    public String topic;

    /*Fecha de Creación del Mensaje */
    public String timeStamp;

    /*Mensaje del dispositivo clave(String) - Valor(String, Int, etc..)*/
    public Map<String, Object> values;

    /*Estado del Dispositivo (opcional)*/
    public String status;
    
    /*Indica si el mensaje es una alerta (opcional)*/
    public Boolean alert;
    
}
