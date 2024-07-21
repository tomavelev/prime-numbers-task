package com.programtom.consumer.service;


import com.programtom.common.models.RandomNumberBatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

@SpringBootTest
public class BatchNumberServiceTest {


    @Autowired
    PrimeNumberService primeNumberService;

    @Test
    public void testBatch() {
        final List<Long> output = new ArrayList<>();
        BatchNumberService batchNumberService = new BatchNumberService(primeNumberService,
                new CSVService() {
                    @Override
                    public void writeNumbers(RandomNumberBatch randomNumberBatch) {
                        output.addAll(randomNumberBatch.numbers());
                    }
                }
        );

        //These values for in/out are copied from sample run of the app

        List<Long> in = asList(629L, 738L, 941L, 548L, 132L, 260L, 451L, 498L, 117L, 11L, 61L, 565L, 915L, 803L, 666L, 37L, 969L, 696L, 459L, 437L, 654L, 649L, 797L, 561L, 562L, 959L, 756L, 405L, 128L, 181L, 583L, 698L, 172L, 543L, 312L, 970L, 820L, 941L, 642L, 753L, 81L, 6L, 539L, 196L, 540L, 111L, 393L, 323L, 379L, 748L, 247L, 344L, 411L, 899L, 71L, 510L, 749L, 774L, 870L, 252L, 275L, 286L, 484L, 522L, 273L, 42L, 859L, 225L, 662L, 240L, 574L, 773L, 82L, 896L, 833L, 995L, 192L, 646L, 349L, 13L, 475L, 886L, 138L, 370L, 506L, 576L, 372L, 952L, 789L, 227L, 200L, 948L, 807L, 531L, 918L, 478L, 460L, 84L, 254L, 112L);
        List<Long> out = asList(941L,11L,61L,37L,797L,181L,941L,379L,71L,859L,773L,349L,13L,227L);
        RandomNumberBatch batch = new RandomNumberBatch(in, "");

        batchNumberService.consumeNumbers(batch);

        Assert.isTrue(output.equals(out), "Batch Equal Match");
    }
}
