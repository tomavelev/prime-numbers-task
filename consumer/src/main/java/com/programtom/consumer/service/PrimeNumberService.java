package com.programtom.consumer.service;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * A Spring Service that could be injected anywhere and could allow checking if a number is prime.
 */
@Service
public class PrimeNumberService {
    /**
     * Function to check if a number is prime
     *
     * @param number - the number to be checked
     * @return returns true - if the number is prime or false - if the number is not prime
     */
    public boolean isPrime(long number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
