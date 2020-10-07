package com.kth.sep.controller;


import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.service.EventPlanningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event_request/v1/")
public class EventRequestController {

private final EventPlanningService eventPlanningService;

    public EventRequestController(EventPlanningService eventPlanningService) {
        this.eventPlanningService = eventPlanningService;
    }


    @PostMapping("create")
    public EventPlanningRequest createEventPlanningRequest(@RequestBody EventPlanningRequest eventPlanningRequest) {
        return eventPlanningService.createEventPlanningRequest(eventPlanningRequest);

    }

    @PutMapping("scso_approve/{id}")
    public EventPlanningRequest scsoApproveEventPlanningRequest(@RequestParam Integer id) {
        return eventPlanningService.scsoApprove(id);
    }

    @PutMapping("financial_manager_approve")
    public EventPlanningRequest financialManagerAction(@RequestParam(value = "id") Integer id, @RequestParam(value = "feedback") String feedback) {
        return eventPlanningService.financialManagerAction(id, feedback);
    }

    @PutMapping("admin_approve}")
    public EventPlanningRequest adminApprove(@RequestParam(value = "id") Integer id) {
        return eventPlanningService.adminApprove(id);
    }

    @GetMapping("get_all")
    public List<EventPlanningRequest> getAllEventPLanningRequests(){
        return eventPlanningService.getAllEventPlanningRequests();
    }
}
