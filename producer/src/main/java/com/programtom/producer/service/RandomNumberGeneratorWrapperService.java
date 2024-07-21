package com.programtom.producer.service;

import com.programtom.common.models.RandomNumberBatch;
import com.programtom.producer.service.communication.NumberCommunication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unified Service that executes all the job - number generation and communication - so it could be reused / triggered from different places.
 */
@Service
public class RandomNumberGeneratorWrapperService {
    private static final Logger logger = LoggerFactory.getLogger(RandomNumberGeneratorWrapperService.class);

    /**
     * It is not present in the requirement of the task. It is used for file naming purposes.
     */
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_hhmmsss");

    @Autowired
    RandomNumberGeneratorService randomNumberGeneratorService;
    @Autowired
    CSVService csvService;

    @Autowired
    NumberCommunication numberCommunication;

    public void generateAndSendRandomNumbers() {

        //Generating numbers and file name - group / batch
        List<Long> generatedNumbers = randomNumberGeneratorService.generateNumbers();
        String fileName = simpleDateFormat.format(new Date());
        logger.debug("Generating new numbers3...");
        RandomNumberBatch randomNumberBatch = new RandomNumberBatch(generatedNumbers, fileName);

        //sending...
        numberCommunication.send(randomNumberBatch);

        //and if all is OK - write the numbers down
        csvService.writeNumbers(randomNumberBatch);
    }
}