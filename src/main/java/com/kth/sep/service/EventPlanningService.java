package com.kth.sep.service;


import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.exception.EventPlanningRequestNotFoundException;
import com.kth.sep.repository.EventPlaningRequestRepository;
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
    private final EventPlaningRequestRepository eventPlaningRequestRepository;


    public List<EventPlanningRequest> getAllEventPlanningRequests(){
        List<EventPlanningRequest> eventPlanningRequests =
                StreamSupport.stream(eventPlaningRequestRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return eventPlanningRequests;
    }
    public EventPlanningService(EventPlaningRequestRepository eventPlaningRequestRepository) {
        this.eventPlaningRequestRepository = eventPlaningRequestRepository;
    }

    public EventPlanningRequest createEventPlanningRequest(EventPlanningRequest eventPlanningRequest) {
        return eventPlaningRequestRepository.save(eventPlanningRequest);
    }

    public EventPlanningRequest scsoApprove(Integer id) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlaningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setApprovedBySeniorCustomerServiceOfficer(!eventPlanningRequest.getApprovedBySeniorCustomerServiceOfficer());
        return eventPlaningRequestRepository.save(eventPlanningRequest);
        //TODO: include false case as well

    }

    public EventPlanningRequest financialManagerAction(Integer id, String feedback) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlaningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setApprovedByFinancialManager(true);
        eventPlanningRequest.setFinancialManagerFeedback(feedback);
        return eventPlaningRequestRepository.save(eventPlanningRequest);
    }


    public EventPlanningRequest adminApprove(Integer id) throws EventPlanningRequestNotFoundException {
        EventPlanningRequest eventPlanningRequest = eventPlaningRequestRepository.findById(id).orElseThrow(() -> new EventPlanningRequestNotFoundException("The event has been removed"));
        eventPlanningRequest.setApprovedBySeniorCustomerServiceOfficer(!eventPlanningRequest.getApprovedBySeniorCustomerServiceOfficer());
        return eventPlaningRequestRepository.save(eventPlanningRequest);
    }
}