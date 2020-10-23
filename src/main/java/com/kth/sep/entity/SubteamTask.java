package com.kth.sep.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.model.Priority;
import com.kth.sep.model.Status;
import com.kth.sep.model.SubteamDepartment;

import javax.persistence.*;


@Entity
@Table(name = "subteam_task")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubteamTask {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subteamContactName;
    private String description;
    private SubteamDepartment department;
    private Status status;
    private Priority priority;
    private String projectReference;

    @OneToOne(targetEntity=Response.class,cascade=CascadeType.ALL)
    private Response response;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubteamContactName() {
        return subteamContactName;
    }

    public void setSubteamContactName(String subteamContactName) {
        this.subteamContactName = subteamContactName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public SubteamDepartment getDepartment() {
        return department;
    }

    public void setDepartment(SubteamDepartment department) {
        this.department = department;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(String projectReference) {
        this.projectReference = projectReference;
    }
}

