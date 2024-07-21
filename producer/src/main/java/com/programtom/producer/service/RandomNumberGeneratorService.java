package com.programtom.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A Spring Service that has the sole function to generate<br>
 * - 100 random numbers<br>
 * - up to 5 per second
 */
@Service
public class RandomNumberGeneratorService {
    private static final Logger logger = LoggerFactory.getLogger(RandomNumberGeneratorService.class);

    private static final int MAX_STREAM_SIZE = 100;
    private static final int MAX_NUMBERS_PER_SECOND = 5;

    private final Random random = new Random();

    /**
     * Function to generate List of random numbers
     *
     * @return List of random numbers
     */
    public List<Long> generateNumbers() {
        logger.debug("generateNumbers...");
        final List<Long> batchBuffer = new ArrayList<>();

        for (int i = 0; i < MAX_STREAM_SIZE; i++) {
            if (i > 0 && i % MAX_NUMBERS_PER_SECOND == 0) {
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }

            logger.debug("generateNumbers {}", i);
            batchBuffer.add(random.nextLong(0L, 1000)); // Generate a random number and add it to the list
        }

        logger.debug("generateNumbers finished");
        return batchBuffer;
    }
}
