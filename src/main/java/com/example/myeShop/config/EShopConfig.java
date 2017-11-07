package com.example.myeShop.config;

import com.mongodb.MongoClient;

import com.mongodb.ServerAddress;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoFactory;
import org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.documentperevent.DocumentPerEventStorageStrategy;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.example.myeShop")
@EnableMongoRepositories(basePackages = "com.example.myeShop")
public class EShopConfig {

    @Autowired
    private AxonConfiguration axonConfiguration;

    @Autowired
    private EventBus eventBus;

    @Bean
    public Serializer axonJsonSerializer() {
        return new JacksonSerializer();
    }

    @Bean
    public MongoEventStorageEngine eventStorageEngine(){
        return new MongoEventStorageEngine(axonJsonSerializer(), null, axonMongoTemplate(), new DocumentPerEventStorageStrategy());
    }

    @Bean(name = "axonMongoTemplate")
    public MongoTemplate axonMongoTemplate() {
        MongoTemplate template = new DefaultMongoTemplate(mongoClient(), "eshop", "events", "snapshots");
        return template;
    }

    @Bean
    public MongoClient mongoClient(){
        MongoFactory mongoFactory = new MongoFactory();
        mongoFactory.setMongoAddresses(Collections.singletonList(new ServerAddress("localhost", 27017)));
        return mongoFactory.createMongo();
    }

}
