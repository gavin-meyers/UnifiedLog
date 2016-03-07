package com.ulp.base;

import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Created by gameyers on 07/03/16.
 */
public class Event {

    private String topic;
    private String message;

    public Event(){

    }

    public Event(String topic, String message){
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Event [");
        sb.append("topic='").append(topic).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(']');
        return sb.toString();
    }
}
