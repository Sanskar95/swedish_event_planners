package com.kth.sep.controller;


import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.service.FinancialRequestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/financial_request/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FinancialRequestController {

    private final FinancialRequestService financialRequestService;

    public FinancialRequestController(FinancialRequestService financialRequestService) {
        this.financialRequestService = financialRequestService;
    }

//    @RolesAllowed({"ADMIN"})
    @GetMapping("get_all")
    public List<FinancialRequest> getAllFinancialRequests(){
        return financialRequestService.getAllFinncialRequests();
    }

    @PutMapping("modify")
    public FinancialRequest respondToFinancialRequest(@RequestParam(value = "id") Integer id, @RequestParam(value = "agreedAmount") Double agreedAmount, @RequestBody Response response) throws FinancialRequestNotFoundException {
        return  financialRequestService.modifyFinancialRequest(id , agreedAmount, response);
    }

    @PostMapping("create")
    public FinancialRequest createFinancialRequest( @RequestBody FinancialRequest financialRequest){
      return   financialRequestService.createFinancialRequest(financialRequest);
    }
}
