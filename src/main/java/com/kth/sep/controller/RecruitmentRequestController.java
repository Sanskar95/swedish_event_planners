package com.kth.sep.controller;


import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.RecruitmentRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.service.RecruitmentRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitment_request/")
public class RecruitmentRequestController {

    private final RecruitmentRequestService recruitmentRequestService;

    public RecruitmentRequestController(RecruitmentRequestService recruitmentRequestService) {
        this.recruitmentRequestService = recruitmentRequestService;
    }

    @GetMapping("get_all")
    public List<RecruitmentRequest> getAllRecruitmentRequests(){
        return recruitmentRequestService.getAllRecruitmentRequests();
    }

    @PutMapping("modify")
    public RecruitmentRequest respondToRecruitmentRequest(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") String status, @RequestBody Response response) throws FinancialRequestNotFoundException, RecruitmentRequetNotFoundException {
        return  recruitmentRequestService.modifyRecruitmentRequest(id , response, status);
    }

    @PostMapping("create")
    public RecruitmentRequest createRecruitmentRequest(@RequestBody RecruitmentRequest recruitmentRequest){
        return   recruitmentRequestService.createRecruitmentRequest(recruitmentRequest);
    }
}
