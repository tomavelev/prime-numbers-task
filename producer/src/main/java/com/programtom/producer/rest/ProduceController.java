package com.programtom.producer.rest;

import com.programtom.producer.service.RandomNumberGeneratorWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    RandomNumberGeneratorWrapperService randomNumberGeneratorWrapperService;

    /**
     * If external activation of random number generation is chosen - you could start the process from here.
     * If you choose to not expose it - this code is not needed
     */
    @GetMapping("generate")
    public void generate() {
        randomNumberGeneratorWrapperService.generateAndSendRandomNumbers();
    }

}
