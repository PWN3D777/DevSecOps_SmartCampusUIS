
# Repositorio Microservicio de Datos/Mensajes IoT

En este repositorio se encuentra el código fuente del microservicio de almacenamiento de datos para la plataforma Smart Campus IoT UIS. 

El microservicio está desarrollado en las siguientes tecnologías: 

- Java 11
- Spring Boot 2.7.11
Dependencias:
- Spring Data MongoDB
- Spring Web
- MQTT integration. 
- Gson
- Lombok

El proyecto cuenta con los siguientes directorios internos: 

- **CONFIG**: Directorio para los archivos de configuración del microservico como el archivo de configuración de CORS y el SaggerConfig.

- **Controller**: Para los controladores de las HTTP Request.

- **Documents**: Directorio para los modelos que representan los documentos que serán almacenados en MongoDB.

- **Dto**: Para las clases POJO de la applicación.

- **Repository**: Configuración de acceso a repositorio de datos de MongoDB.

- **Service**: Implementación de los servicios internos como el servicio de procesamiento de datos para MQTT y el servicio que expone los datos por API REST. 


Este servicio está diseñado para ejecutarse en un contenedor donde existen las siguientes variables de entorno: 

- **MONGO_HOST**: IP Host de la base de datos MongoDB.
- **BROKER_IP**: IP Broker MQTT. 

Para agregar variables adionales se debe modificar el application.yml y para MQTT revisar MessagesApplication.java.

## API Document. 

Para conocer los EndPoin de la API que expone el microservicio se instalo el paquete de Swagger que permite documenta fácilmente, para acceder se expone por la URL base del servicio + */swagger-ui.html#/*

