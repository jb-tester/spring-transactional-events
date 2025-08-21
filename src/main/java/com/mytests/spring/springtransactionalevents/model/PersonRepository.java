package com.mytests.spring.springtransactionalevents.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *
 * <p>Created by Irina on 8/21/2025.</p>
 * *
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    @Query("select e from Person e where e.firstName = :firstName")
    List<Person> customQuery(@Param("firstName") String arg);
}