package com.ulp.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by gameyers on 07/03/16.
 */
public class EventConsumer {
    private ObjectMapper mapper = new ObjectMapper();
    private KafkaConsumer<String, String> consumer;
    List<String> topics;

    public EventConsumer(){
        topics = new ArrayList<>();
    }

    public EventConsumer(String configFilePath, List<String> topics){
        this();
        try (InputStream props = Resources.getResource(configFilePath).openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            if (properties.getProperty("group.id") == null) {
                properties.setProperty("group.id", "group-" + new Random().nextInt(100000));
            }
            consumer = new KafkaConsumer<>(properties);
            this.topics.addAll(topics);
            consumer.subscribe(this.topics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //crappy
    public EventConsumer subscribeToTopic(String topicName){
        topics.add(topicName);
        consumer.subscribe(topics);
        return this;
    }
    //crappy
    public ConsumerRecords readFromTopic(){
        return consumer.poll(100);
    }

}
