package com.kth.sep.service;


import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.SubteamTask;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.FinancialRequestNotFoundException;
import com.kth.sep.exception.SubteamTaskNotFoundException;
import com.kth.sep.model.Status;
import com.kth.sep.repository.SubteamTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SubteamTaskService {

    private final SubteamTaskRepository subteamTaskRepository;

    public SubteamTaskService(SubteamTaskRepository subteamTaskRepository) {
        this.subteamTaskRepository = subteamTaskRepository;
    }

    public List<SubteamTask> getAllSubteamTasks(){
        List<SubteamTask> subteamTasks =
                StreamSupport.stream(subteamTaskRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return subteamTasks;
    }

    public SubteamTask modifySubteamTask(Integer id, String status , Response response) throws SubteamTaskNotFoundException {
        SubteamTask subteamTask = subteamTaskRepository.findById(id).orElseThrow(() -> new SubteamTaskNotFoundException("Task not found"));
        subteamTask.setStatus(Status.valueOf(status));
        subteamTask.setResponse(response);
        return subteamTask;
    }
}
