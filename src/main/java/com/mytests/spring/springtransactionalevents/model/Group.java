package com.mytests.spring.springtransactionalevents.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty @Size(min = 2, max = 15)
    private String name;
    @NotNull @NotEmpty
    private String description;
    @Min(1)
    private String amount;

    public Group(String name, String description, String amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", amount='" + amount + '\'' +
               '}';
    }
}
