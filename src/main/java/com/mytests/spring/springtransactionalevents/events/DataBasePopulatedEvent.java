package com.mytests.spring.springtransactionalevents.events;


import org.springframework.context.ApplicationEvent;

public class DataBasePopulatedEvent extends ApplicationEvent {
    private final int amount;
    private final String dbName;
    private final String message;

    public DataBasePopulatedEvent(Object source, int amount, String dbName, String message) {
        super(source);
        this.amount = amount;
        this.dbName = dbName;
        this.message = message;
    }
    public int getAmount() {
        return amount;
    }
    public String getMessage() {
        return message;
    }

    public String getDbName() {
        return dbName;
    }
}
