package com.kth.sep.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.model.Status;

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
    private String departmemt;
    private Status status;
    private String priority;

    @OneToOne
    @JoinColumn(name="id")
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDepartmemt() {
        return departmemt;
    }

    public void setDepartmemt(String departmemt) {
        this.departmemt = departmemt;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

