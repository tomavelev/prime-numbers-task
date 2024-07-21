package com.programtom.consumer.service;

import com.programtom.common.models.RandomNumberBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class CSVService {
    private static final Logger logger = LoggerFactory.getLogger(CSVService.class);

    @Value("${csv.rootDirectory}")
    String rootDirectory;

    @Value("${csv.file.suffix}")
    String suffix;


    public void writeNumbers(RandomNumberBatch randomNumberBatch) {

        //noinspection StringBufferReplaceableByString
        String fileName = new StringBuilder().append(randomNumberBatch.fileName()).append("_").append(suffix).append(".csv").toString();
        try (FileWriter fileWriter = new FileWriter(new File(rootDirectory, fileName), StandardCharsets.UTF_8)) {
            fileWriter.write((randomNumberBatch.numbers().stream())
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
