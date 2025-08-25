package com.mytests.spring.springtransactionalevents.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    List<Group> findAll();

    List<Group> findByName(String name);

    @Modifying
    @Query("update Group e set e.amount = :amount where e.name = :name")
    void updateGroupAmountByName(@Param("name") String arg1, @Param("amount") int arg2);
}