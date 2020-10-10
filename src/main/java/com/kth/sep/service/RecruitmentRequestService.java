package com.kth.sep.service;


import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.entity.RecruitmentRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.repository.RecruitmentRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecruitmentRequestService {
    private final RecruitmentRequestRepository recruitmentRequestRepository;

    public RecruitmentRequestService(RecruitmentRequestRepository recruitmentRequestRepository) {
        this.recruitmentRequestRepository = recruitmentRequestRepository;
    }

    public List<RecruitmentRequest> getAllRecruitmentRequests() {
        List<RecruitmentRequest> recruitmentRequests =
                StreamSupport.stream(recruitmentRequestRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return recruitmentRequests;
    }

    public RecruitmentRequest modifyRecruitmentRequest(Integer id, Response response, String status) throws RecruitmentRequetNotFoundException {
        RecruitmentRequest recruitmentRequest = recruitmentRequestRepository.findById(id).orElseThrow(() -> new RecruitmentRequetNotFoundException("The request does not exist"));
        recruitmentRequest.setStatus(status);
        recruitmentRequest.setResponse(response);
        recruitmentRequestRepository.save(recruitmentRequest);
        return recruitmentRequest;

    }
}
