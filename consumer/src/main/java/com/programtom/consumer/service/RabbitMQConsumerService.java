package com.programtom.consumer.service;

import com.programtom.common.models.RandomNumberBatch;
//import com.programtom.consumer.conf.RabbitMQConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerService {

    @Autowired
    BatchNumberService batchNumberService;
//Uncomment - This would be needed for RabbitMQ variant - for Inter - Micro Service Communication

//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeNumbers(RandomNumberBatch randomNumberBatch) {
        batchNumberService.consumeNumbers(randomNumberBatch);
    }


}
