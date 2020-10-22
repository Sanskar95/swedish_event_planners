package com.kth.sep.service;


import com.kth.sep.entity.RecruitmentRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.model.Status;
import com.kth.sep.repository.RecruitmentRequestRepository;
import com.kth.sep.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecruitmentRequestService {
    private final RecruitmentRequestRepository recruitmentRequestRepository;
    private final ResponseRepository responseRepository;


    public RecruitmentRequestService(RecruitmentRequestRepository recruitmentRequestRepository, ResponseRepository responseRepository) {
        this.recruitmentRequestRepository = recruitmentRequestRepository;
        this.responseRepository = responseRepository;
    }

    public List<RecruitmentRequest> getAllRecruitmentRequests() {
        List<RecruitmentRequest> recruitmentRequests =
                StreamSupport.stream(recruitmentRequestRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return recruitmentRequests;
    }

    public RecruitmentRequest modifyRecruitmentRequest(Integer id, Response response, String status) throws RecruitmentRequetNotFoundException {
        RecruitmentRequest recruitmentRequest = recruitmentRequestRepository.findById(id).orElseThrow(() -> new RecruitmentRequetNotFoundException("The request does not exist"));
        recruitmentRequest.setStatus(Status.valueOf(status));
        recruitmentRequest.setResponse(responseRepository.save(response));
        return recruitmentRequestRepository.save(recruitmentRequest);


    }

    public RecruitmentRequest createRecruitmentRequest(RecruitmentRequest recruitmentRequest) {
        return recruitmentRequestRepository.save(recruitmentRequest);
    }
}
