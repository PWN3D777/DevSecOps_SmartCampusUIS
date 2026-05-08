package com.smartuis.module.application.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean(name = "anonQueue")
    public Queue anonQueue(
            @Value("${rabbitmq.queue:device.messages}") String queueName
    ) {
        return QueueBuilder.durable(queueName).build();
    }
}
