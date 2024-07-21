package com.programtom.consumer.service;

import com.programtom.common.models.RandomNumberBatch;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchNumberService {

    final PrimeNumberService primeNumberService;
    final CSVService csvService;

    private static final Logger logger = LoggerFactory.getLogger(BatchNumberService.class);

    @SuppressFBWarnings
    public BatchNumberService(PrimeNumberService primeNumberService, CSVService csvService) {
        this.primeNumberService = primeNumberService;
        this.csvService = csvService;
    }

    public void consumeNumbers(RandomNumberBatch randomNumberBatch) {
        List<Long> primeList = randomNumberBatch.numbers().stream().filter(primeNumberService::isPrime).toList();
        csvService.writeNumbers(new RandomNumberBatch(primeList, randomNumberBatch.fileName()));
        logger.debug("consumed numbers : {}", randomNumberBatch);
    }
}
