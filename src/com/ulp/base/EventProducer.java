package com.ulp.base;

import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gameyers on 07/03/16.
 */
public class EventProducer {

    KafkaProducer<String, String> producer;
    Logger logger;

    public EventProducer() {
         logger = LoggerFactory.getLogger(EventProducer.class);
    }

    public EventProducer(String configFile) {
        this();
        try {
            InputStream props = Resources.getResource(configFile).openStream();
            Properties properties = new Properties();
            properties.load(props);
            producer = new KafkaProducer<String, String>(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param topic
     * topic - "fast-messages", "fast-messages", "summary-markers"
     *
     *
     */
    public void sendEvent(ProducerRecord pRecord) {
        try {
            producer.send(pRecord);
            producer.flush();
        } catch (Throwable throwable) {
            System.out.printf("%s", throwable.getStackTrace());
        } finally {
            producer.close();
        }
    }
}
