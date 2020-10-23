package com.kth.sep.service;


import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.exception.EventPlanningRequestNotFoundException;
import com.kth.sep.repository.EventPlanningRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventPlanningService {
    private Logger logger = LoggerFactory.getLogger(EventPlanningService.class);
    private final EventPlanningRequestRepository eventPlanningRequestRepository;


    public List<EventPlanningRequest> getAllEventPlanningRequests(){
        List<EventPlanningRequest> eventPlanningRequests =
                StreamSupport.stream(eventPlanningRequestRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return eventPlanningRequests;
    }
    public EventPlanningService(EventPlanningRequestRepository eventPlanningRequestRepository) {
        this.eventPlanningRequestRepository = eventPlanningRequestRepository;
    }

    public EventPlanningRequest createEventPlanningRequest(EventPlanningRequest eventPlanningRequest) {
        return eventPlanningRequestRepository.save(eventPlanningRequest);
    }

    public EventPlanningRequest scsoApprove(Integer id) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest1 = eventPlanningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest1.setApprovedBySeniorCustomerServiceOfficer(!eventPlanningRequest1.getApprovedBySeniorCustomerServiceOfficer());
        return eventPlanningRequestRepository.save(eventPlanningRequest1);
        //TODO: include false case as well

    }

    public EventPlanningRequest financialManagerAction(Integer id, String feedback) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlanningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setApprovedByFinancialManager(true);
        eventPlanningRequest.setFinancialManagerFeedback(feedback);
        return eventPlanningRequestRepository.save(eventPlanningRequest);
    }


    public EventPlanningRequest adminApprove(Integer id) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlanningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setApprovedByAdminManager(!eventPlanningRequest.getApprovedByAdminManager());
        return eventPlanningRequestRepository.save(eventPlanningRequest);
    }

    public EventPlanningRequest finalScsoApprove(Integer id) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlanningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setFinalScsoApproval(!eventPlanningRequest.getFinalScsoApproval());
        return eventPlanningRequestRepository.save(eventPlanningRequest);
    }
}
