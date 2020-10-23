package com.kth.sep.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kth.sep.entity.reply.Response;
import com.kth.sep.model.RequestingDepartment;
import com.kth.sep.model.Status;

import javax.persistence.*;

@Entity
@Table(name = "recruitment_request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecruitmentRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contractType;
    private RequestingDepartment requestingDepartment;
    private Double yearsOfExperience;
    private String jobTitle;
    private Status status;
    private String jobDescription;

    @OneToOne(targetEntity=Response.class,cascade=CascadeType.ALL)
    private Response response;

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public RequestingDepartment getRequestingDepartment() {
        return requestingDepartment;
    }

    public void setRequestingDepartment(RequestingDepartment requestingDepartment) {
        this.requestingDepartment = requestingDepartment;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
