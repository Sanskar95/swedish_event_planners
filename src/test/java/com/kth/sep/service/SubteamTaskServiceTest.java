package com.kth.sep.service;

import com.kth.sep.entity.SubteamTask;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.exception.RecruitmentRequetNotFoundException;
import com.kth.sep.exception.SubteamTaskNotFoundException;
import com.kth.sep.model.Status;
import com.kth.sep.repository.SubteamTaskRepository;
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

public class SubteamTaskServiceTest {
    @InjectMocks
    SubteamTaskService subteamTaskService;

    @Mock
    SubteamTaskRepository subteamTaskRepository;

    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.LENIENT);
    private SubteamTask SubteamTask1;

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
    public void testGetAllSubteamTasks(){
        SubteamTask SubteamTask =new SubteamTask();
        SubteamTask.setSubteamContactName("morty");

//        Response response = new Response();
//        response.setMessage("Some response message");
//        response.setSource("Recruitment");

        ArrayList<SubteamTask> SubteamTasks = new ArrayList<>();
        SubteamTasks.add(SubteamTask);
        when(subteamTaskRepository.findAll()).thenReturn(SubteamTasks);

        List<SubteamTask> SubteamTasks1 = subteamTaskService.getAllSubteamTasks();
        Assert.assertEquals(SubteamTasks1, SubteamTasks);

    }

    @Test
    public void testCreateSubteamTask(){
        SubteamTask SubteamTask = new SubteamTask();
        SubteamTask.setSubteamContactName("morty");


        when(subteamTaskRepository.save(SubteamTask)).thenReturn(SubteamTask);
        SubteamTask SubteamTask1= subteamTaskService.createSubteamTask(SubteamTask);
        Assert.assertEquals(SubteamTask1,SubteamTask);

    }


    @Test
    public void testFMAction() throws RecruitmentRequetNotFoundException, SubteamTaskNotFoundException {
        SubteamTask SubteamTask = new SubteamTask();
        SubteamTask.setSubteamContactName("morty");
        SubteamTask.setId(1);

        Response response = new Response();
        response.setMessage("Some response message");
        response.setSource("Recruitment");

        SubteamTask SubteamTask1 = new SubteamTask();
        SubteamTask.setSubteamContactName("morty");
        SubteamTask1.setId(1);
        SubteamTask1.setResponse(response);
        SubteamTask1.setStatus(Status.toDo);
        when(subteamTaskRepository.save(SubteamTask)).thenReturn(SubteamTask);
        when(responseRepository.save(response)).thenReturn(response);

        when(subteamTaskRepository.findById(1)).thenReturn(java.util.Optional.of(SubteamTask));
        SubteamTask SubteamTask2 = subteamTaskService.modifySubteamTask(1,"toDo",response);
        Assert.assertEquals(java.util.Optional.ofNullable(SubteamTask2.getStatus()), Optional.of(Status.toDo));

    }

}
