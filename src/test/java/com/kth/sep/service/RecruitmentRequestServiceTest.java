package com.kth.sep.service;

import com.kth.sep.entity.RecruitmentRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.model.Status;
import com.kth.sep.repository.RecruitmentRequestRepository;
import com.kth.sep.repository.ResponseRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

public class RecruitmentRequestServiceTest {
    @InjectMocks
    RecruitmentRequestService recruitmentRequestService;

    @Mock
    RecruitmentRequestRepository recruitmentRequestRepository;

    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);
    private RecruitmentRequest RecruitmentRequest1;

    @Mock
    ResponseRepository responseRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testGetAllRecruitmentRequests(){
        RecruitmentRequest RecruitmentRequest =new RecruitmentRequest();
        RecruitmentRequest.setJobDescription("Desc");

//        Response response = new Response();
//        response.setMessage("Some response message");
//        response.setSource("Recruitment");

        ArrayList<RecruitmentRequest> RecruitmentRequests = new ArrayList<>();
        RecruitmentRequests.add(RecruitmentRequest);
        when(recruitmentRequestRepository.findAll()).thenReturn(RecruitmentRequests);

        List<RecruitmentRequest> RecruitmentRequests1 = recruitmentRequestService.getAllRecruitmentRequests();
        Assert.assertEquals(RecruitmentRequests1, RecruitmentRequests);

    }

    @Test
    public void testCreateRecruitmentRequest(){
        RecruitmentRequest RecruitmentRequest = new RecruitmentRequest();
        RecruitmentRequest.setJobDescription("Desc");


        when(recruitmentRequestRepository.save(RecruitmentRequest)).thenReturn(RecruitmentRequest);
        RecruitmentRequest RecruitmentRequest1= recruitmentRequestService.createRecruitmentRequest(RecruitmentRequest);
        Assert.assertEquals(RecruitmentRequest1,RecruitmentRequest);

    }


    @Test
    public void testFMAction() throws  RecruitmentRequetNotFoundException {
        RecruitmentRequest RecruitmentRequest = new RecruitmentRequest();
        RecruitmentRequest.setJobDescription("Desc");
        RecruitmentRequest.setId(1);

        Response response = new Response();
        response.setMessage("Some response message");
        response.setSource("Recruitment");

        RecruitmentRequest RecruitmentRequest1 = new RecruitmentRequest();
        RecruitmentRequest.setJobDescription("Desc");
        RecruitmentRequest1.setId(1);
        RecruitmentRequest1.setResponse(response);
        RecruitmentRequest1.setStatus(Status.toDo);
        when(recruitmentRequestRepository.save(RecruitmentRequest)).thenReturn(RecruitmentRequest);
        when(responseRepository.save(response)).thenReturn(response);

        when(recruitmentRequestRepository.findById(1)).thenReturn(java.util.Optional.of(RecruitmentRequest));
        RecruitmentRequest RecruitmentRequest2 = recruitmentRequestService.modifyRecruitmentRequest(1,response,"toDo");
        Assert.assertEquals(java.util.Optional.ofNullable(RecruitmentRequest2.getStatus()), Optional.of(Status.toDo));

    }

}
