package com.mytests.spring.springtransactionalevents.model;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GroupService {

    private final GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public void displayAll() {
        repository.findAll().forEach(System.out::println);
    }

    @Transactional
    public Group saveGroup(Group group) {
        return repository.save(group);
    }

    @Transactional
    public void updateGroup(String name) {
        int amount = repository.findByName(name).size();
        if (amount == 0) {
            this.saveGroup(new Group(name, "new group "+name, "1"));
        } else {
        repository.updateGroupAmountByName(name, amount + 1);
    }}

}