package com.programtom.consumer.conf;

//Uncomment - This would be needed for RabbitMQ variant - for Inter - Micro Service Communication
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String QUEUE_NAME = "randomNumbersQueue";
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(jackson2JsonMessageConverter());
//        return template;
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
//                                                                   MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    @Bean
//    public MessageListenerAdapter listenerAdapter(RabbitMQConsumerService receiver) {
//        MessageListenerAdapter adapter = new MessageListenerAdapter(receiver, "consumeNumbers");
//        adapter.setMessageConverter(jackson2JsonMessageConverter());
//        return adapter;
//    }
//
//    @Bean
//    public Queue randomNumbersQueue() {
//        return new Queue(QUEUE_NAME, false);
//    }
//}