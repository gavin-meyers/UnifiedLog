package com.ulp.base;

import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Created by gameyers on 07/03/16.
 */
public class EventManager {
    //TODO: need to think long and hard about what I want this class to do
    public ProducerRecord createEvent(Event evntObj){

        ProducerRecord tuple = new ProducerRecord(evntObj.getTopic(),
                evntObj.getMessage());

        return tuple;

    }
}
