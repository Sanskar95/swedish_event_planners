package com.kth.sep.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kth.sep.model.RequestingDepartment;

import javax.persistence.*;

@Entity
@Table(name = "financial_request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private RequestingDepartment requestingDepartment;
    private Double requestedAmount;
    private Double agreedAmount;


    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RequestingDepartment getRequestingDepartment() {
        return requestingDepartment;
    }

    public void setRequestingDepartment(RequestingDepartment requestingDepartment) {
        this.requestingDepartment = requestingDepartment;
    }

    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
