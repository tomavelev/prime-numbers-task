package com.programtom.producer;

import com.programtom.producer.service.RandomNumberGeneratorWrapperService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
@EnableAutoConfiguration
public class ProducerApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        //as not specified in requirements - generating new random numbers to send is not exposed to public (REST or WEB),
        //new numbers will be generated on producer service - start / restart

//        RandomNumberGeneratorWrapperService randomNumberGeneratorService = applicationContext.getBean(RandomNumberGeneratorWrapperService.class);
//        randomNumberGeneratorService.generateAndSendRandomNumbers();

    }
}
