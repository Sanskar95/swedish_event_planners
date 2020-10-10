package com.kth.sep.controller;

import com.kth.sep.entity.SubteamTask;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.exception.SubteamTaskNotFoundException;
import com.kth.sep.service.SubteamTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitment_request/")
public class SubteamTaskController {

    private final SubteamTaskService subteamTaskService;

    public SubteamTaskController(SubteamTaskService subteamTaskService) {
        this.subteamTaskService = subteamTaskService;
    }


    @GetMapping("get_all")
    public List<SubteamTask> getAllSubteamTasks(){
        return subteamTaskService.getAllSubteamTasks();
    }

    @PutMapping("modify")
    public SubteamTask respondToSubteamTask(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") String status, @RequestBody Response response) throws FinancialRequestNotFoundException, RecruitmentRequetNotFoundException, SubteamTaskNotFoundException {
        return  subteamTaskService.modifySubteamTask(id , status, response);
    }
}
