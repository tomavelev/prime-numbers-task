package com.programtom.consumer.rest;

import com.programtom.common.models.RandomNumberBatch;
import com.programtom.consumer.service.BatchNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRestController {

    @Autowired
    BatchNumberService batchNumberService;

    @PostMapping("/consume")
    public void consumer(@RequestBody RandomNumberBatch batch) {
        batchNumberService.consumeNumbers(batch);
    }

}
