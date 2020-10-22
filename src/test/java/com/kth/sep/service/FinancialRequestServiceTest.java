package com.kth.sep.service;

import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.repository.FinancialRequestRepository;
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

public class FinancialRequestServiceTest {
    @InjectMocks
    FinancialRequestService financialRequestService;

    @Mock
    FinancialRequestRepository financialRequestRepository;

    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);
    private FinancialRequest financialRequest1;

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
    public void testGetAllFinancialRequests(){
        FinancialRequest financialRequest =new FinancialRequest();
        financialRequest.setProjectReference("Some_NUmber");

//        Response response = new Response();
//        response.setMessage("Some response message");
//        response.setSource("financial");

        ArrayList<FinancialRequest> financialRequests = new ArrayList<>();
        financialRequests.add(financialRequest);
        when(financialRequestRepository.findAll()).thenReturn(financialRequests);

        List<FinancialRequest> financialRequests1 = financialRequestService.getAllFinncialRequests();
        Assert.assertEquals(financialRequests1, financialRequests);

    }

    @Test
    public void testCreatefinancialRequest(){
        FinancialRequest financialRequest = new FinancialRequest();
        financialRequest.setProjectReference("Some sc");


        when(financialRequestRepository.save(financialRequest)).thenReturn(financialRequest);
        FinancialRequest financialRequest1= financialRequestService.createFinancialRequest(financialRequest);
        Assert.assertEquals(financialRequest1,financialRequest);

    }


    @Test
    public void testFMAction() throws  FinancialRequestNotFoundException {
        FinancialRequest financialRequest = new FinancialRequest();
        financialRequest.setProjectReference("Some sc");
        financialRequest.setId(1);

        Response response = new Response();
        response.setMessage("Some response message");
        response.setSource("financial");

        FinancialRequest financialRequest1 = new FinancialRequest();
        financialRequest.setProjectReference("Some sc");
        financialRequest1.setId(1);
        financialRequest1.setResponse(response);
        financialRequest1.setAgreedAmount(50.0);
        when(financialRequestRepository.save(financialRequest)).thenReturn(financialRequest);
        when(responseRepository.save(response)).thenReturn(response);

        when(financialRequestRepository.findById(1)).thenReturn(java.util.Optional.of(financialRequest));
        FinancialRequest financialRequest2 = financialRequestService.modifyFinancialRequest(1,50.0,response);
        Assert.assertEquals(java.util.Optional.ofNullable(financialRequest2.getAgreedAmount()), Optional.of(50.0));

    }

}
