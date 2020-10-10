package com.kth.sep.service;


import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.repository.FinancialRequestRepository;
import com.kth.sep.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FinancialRequestService {
    private final FinancialRequestRepository financialRequestRepository;
    private final ResponseRepository responseRepository;

    public FinancialRequestService(FinancialRequestRepository financialRequestRepository, ResponseRepository responseRepository) {
        this.financialRequestRepository = financialRequestRepository;
        this.responseRepository = responseRepository;
    }

    public List<FinancialRequest> getAllFinncialRequests(){
        List<FinancialRequest> financialRequests =
                StreamSupport.stream(financialRequestRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return financialRequests;
    }

    public FinancialRequest modifyFinancialRequest(Integer id, Double agreedAmount , Response response) throws FinancialRequestNotFoundException {
        FinancialRequest financialRequest = financialRequestRepository.findById(id).orElseThrow(() -> new FinancialRequestNotFoundException("The event has been removed"));
        financialRequest.setAgreedAmount(agreedAmount);
        financialRequest.setResponse(responseRepository.save(response));
        financialRequestRepository.save(financialRequest);
        return financialRequest;
    }

    public FinancialRequest createFinancialRequest(FinancialRequest financialRequest) {
       return financialRequestRepository.save(financialRequest);
    }
}

