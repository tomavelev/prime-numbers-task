package com.programtom.consumer.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class PrimeNumberServiceTest {

    @Autowired
    PrimeNumberService primeNumberService;

    @Test
    public void testPrimeNumber(){
        primeNumberService.isPrime(2);

        Assert.isTrue(primeNumberService.isPrime(2), "Prime Number test 1");
        Assert.isTrue(primeNumberService.isPrime(17), "Prime Number test 1");
        Assert.isTrue(!primeNumberService.isPrime(16), "Prime Number test 1");
    }
}
