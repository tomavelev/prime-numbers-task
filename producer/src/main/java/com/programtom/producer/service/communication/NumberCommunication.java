package com.programtom.producer.service.communication;

import com.programtom.common.models.RandomNumberBatch;

/**
 * An interface for all the number messengers that need to implement.
 */
public interface NumberCommunication {
    /**
     * Send Numbers to the consumer microservice
     * @param randomNumberBatch - a named stream of numbers
     */
    void send(RandomNumberBatch randomNumberBatch);
}
