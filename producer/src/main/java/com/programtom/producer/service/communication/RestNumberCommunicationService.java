package com.programtom.producer.service.communication;

import com.programtom.common.models.RandomNumberBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * REST implementation of the inter-microservice communication.
 * <p>
 * Because there are two implementations now - it requires a @Primary annotation.
 */
@SuppressWarnings("unused")
@Primary
@Service
public class RestNumberCommunicationService implements NumberCommunication {

    @Autowired
    RestTemplate restTemplate;

    /**
     * The endpoint of the consumer is placed in the application properties file. It could be externally overwritten with docker-compose.yaml setting
     */
    @Value("${consumer.endpoint}")
    String consumerEndpoint;

    @Override
    public void send(RandomNumberBatch randomNumberBatch) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RandomNumberBatch> request = new HttpEntity<>(randomNumberBatch, headers);

        restTemplate.exchange(consumerEndpoint, HttpMethod.POST, request, Void.class);
    }
}
