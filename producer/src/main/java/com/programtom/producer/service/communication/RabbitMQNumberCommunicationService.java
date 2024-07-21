package com.programtom.producer.service.communication;

import com.programtom.common.models.RandomNumberBatch;
import com.programtom.producer.conf.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Rabbit MQ implementation of the inter-microservice communication.
 */
@SuppressWarnings("unused")
@Service
public class RabbitMQNumberCommunicationService implements NumberCommunication {

    private final RabbitTemplate rabbitTemplate;

    @SuppressWarnings("unused")
    public RabbitMQNumberCommunicationService(RabbitTemplate pRabbitTemplate) {
        rabbitTemplate = pRabbitTemplate;
    }

    @Override
    public void send(RandomNumberBatch randomNumberBatch) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, randomNumberBatch);
    }
}
