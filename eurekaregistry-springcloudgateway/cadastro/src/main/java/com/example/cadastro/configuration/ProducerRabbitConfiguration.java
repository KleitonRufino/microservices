package com.example.cadastro.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitConfiguration {

    @Value("${cadastro.client.rabbitmq.routingkey}")
    private String queue;

    @Value("${cadastro.menu.rabbitmq.routingkey}")
    private String queue2;
    
    @Value("${cadastro.rabbitmq.exchange}")
    private String exchange;

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }


    @Bean
    Queue queue() {
        return  QueueBuilder.durable(queue)
                .deadLetterExchange(exchange)
                .build();
    }

    @Bean
    Queue queue2() {
        return  QueueBuilder.durable(queue2)
                .deadLetterExchange(exchange)
                .build();
    }


    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue())
                .to(exchange()).with(queue);
    }

    @Bean
    public Binding bindingQueue2() {
        return BindingBuilder.bind(queue2())
                .to(exchange()).with(queue2);
    }
}
