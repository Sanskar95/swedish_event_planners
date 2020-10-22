package com.kth.sep.service;

import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.exception.EventPlanningRequestNotFoundException;
import com.kth.sep.repository.EventPlaningRequestRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

public class EventPlanningServiceTest {

    @InjectMocks
    EventPlanningService eventPlanningService;

    @Mock
    EventPlaningRequestRepository eventPlaningRequestRepository;

    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }




    @Test
    public void testGetAllEventPlanningRequests(){
        EventPlanningRequest eventPlanningRequest =new EventPlanningRequest();
        eventPlanningRequest.setClientName("Some Client");
        eventPlanningRequest.setEventName("Some event");

        ArrayList<EventPlanningRequest> eventPlanningRequests = new ArrayList<>();
        eventPlanningRequests.add(eventPlanningRequest);
        when(eventPlaningRequestRepository.findAll()).thenReturn(eventPlanningRequests);

       List<EventPlanningRequest> eventPlanningRequests1 = eventPlanningService.getAllEventPlanningRequests();
        Assert.assertEquals(eventPlanningRequests1, eventPlanningRequests);

    }


@Test
    public void testCreateEventPlanningRequest(){
        EventPlanningRequest eventPlanningRequest = new EventPlanningRequest();
    eventPlanningRequest.setClientName("Some Client");
    eventPlanningRequest.setEventName("Some event");
    when(eventPlaningRequestRepository.save(eventPlanningRequest)).thenReturn(eventPlanningRequest);
     EventPlanningRequest eventPlanningRequest1= eventPlanningService.createEventPlanningRequest(eventPlanningRequest);
     Assert.assertEquals(eventPlanningRequest1.getClientName(), eventPlanningRequest.getClientName());

}


@Test
    public void testScsoApprove() throws EventPlanningRequestNotFoundException {
    EventPlanningRequest eventPlanningRequest = new EventPlanningRequest();
    eventPlanningRequest.setClientName("Some Client");
    eventPlanningRequest.setEventName("Some event");
    eventPlanningRequest.setId(1);

    EventPlanningRequest eventPlanningRequest1 = new EventPlanningRequest();
    eventPlanningRequest1.setClientName("Some Client");
    eventPlanningRequest1.setEventName("Some event");
    eventPlanningRequest1.setId(1);
    eventPlanningRequest1.setApprovedBySeniorCustomerServiceOfficer(true);
    when(eventPlaningRequestRepository.save(eventPlanningRequest1)).thenReturn(eventPlanningRequest1);

    when(eventPlaningRequestRepository.findById(1)).thenReturn(java.util.Optional.of(eventPlanningRequest));
    EventPlanningRequest eventPlanningRequest2 = eventPlanningService.scsoApprove(1);
    Assert.assertEquals(eventPlanningRequest2.getApprovedBySeniorCustomerServiceOfficer(), true);



}


}
