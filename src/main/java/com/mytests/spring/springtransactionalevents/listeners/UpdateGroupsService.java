package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.GroupUpdatedEvent;
import com.mytests.spring.springtransactionalevents.events.PersonAddedEvent;
import com.mytests.spring.springtransactionalevents.model.GroupService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UpdateGroupsService {

    private final GroupService groupService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public UpdateGroupsService(GroupService groupService, ApplicationEventPublisher applicationEventPublisher) {
        this.groupService = groupService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @EventListener
    public void afterPersonAddedEvent(PersonAddedEvent event) {
        groupService.updateGroup(event.getLname());
        applicationEventPublisher.publishEvent(new GroupUpdatedEvent(this, event.getLname()));

    }
}
