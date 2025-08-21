package com.mytests.spring.springtransactionalevents.events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "events")
public class EventsEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private String type;
    private Instant createdAt;

    public EventsEntity(String text, String type, Instant createdAt) {
        this.text = text;
        this.type = type;
        this.createdAt = createdAt;
    }

    public EventsEntity() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "EventsEntity{" +
               "id=" + id +
               ", text='" + text + '\'' +
               ", type='" + type + '\'' +
               ", createdAt=" + createdAt +
               '}';
    }
}
