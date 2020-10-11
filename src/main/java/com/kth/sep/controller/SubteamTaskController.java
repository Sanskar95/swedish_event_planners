package com.kth.sep.controller;

import com.kth.sep.entity.SubteamTask;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.SubteamTaskNotFoundException;
import com.kth.sep.service.SubteamTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subteam_task/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public SubteamTask respondToSubteamTask(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") String status, @RequestBody Response response) throws  SubteamTaskNotFoundException {
        return  subteamTaskService.modifySubteamTask(id , status, response);
    }

    @PostMapping("create")
    public SubteamTask createSubteamTask(@RequestBody SubteamTask subteamTask){
        return   subteamTaskService.createSubteamTask(subteamTask);
    }
}
