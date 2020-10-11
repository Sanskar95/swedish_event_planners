package com.kth.sep.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kth.sep.model.Preferences;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "event_planning_request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventPlanningRequest {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String eventName;
    private String clientName;
    private String eventType;
    private Date startingDate;
    private Date endingDate;
    private Integer numberOfAttendees;
    private Integer expectedBudget;
    private Preferences preferences;

    private Boolean approvedBySeniorCustomerServiceOfficer;
    private Boolean approvedByFinancialManager;
    private Boolean approvedByAdminManager;
    private Boolean finalScsoApproval;

    private String financialManagerFeedback;

    public EventPlanningRequest() {
        this.approvedBySeniorCustomerServiceOfficer = false;
        this.approvedByFinancialManager = false;
        this.approvedByAdminManager = false;
        this.finalScsoApproval= false;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Integer getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(Integer numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public Integer getExpectedBudget() {
        return expectedBudget;
    }

    public void setExpectedBudget(Integer expectedBudget) {
        this.expectedBudget = expectedBudget;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public Boolean getApprovedBySeniorCustomerServiceOfficer() {
        return approvedBySeniorCustomerServiceOfficer;
    }

    public void setApprovedBySeniorCustomerServiceOfficer(Boolean approvedBySeniorCustomerServiceOfficer) {
        this.approvedBySeniorCustomerServiceOfficer = approvedBySeniorCustomerServiceOfficer;
    }

    public Boolean getApprovedByFinancialManager() {
        return approvedByFinancialManager;
    }

    public void setApprovedByFinancialManager(Boolean approvedByFinancialManager) {
        this.approvedByFinancialManager = approvedByFinancialManager;
    }

    public Boolean getApprovedByAdminManager() {
        return approvedByAdminManager;
    }

    public void setApprovedByAdminManager(Boolean approvedByAdminManager) {
        this.approvedByAdminManager = approvedByAdminManager;
    }

    public String getFinancialManagerFeedback() {
        return financialManagerFeedback;
    }

    public void setFinancialManagerFeedback(String financialManagerFeedback) {
        this.financialManagerFeedback = financialManagerFeedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFinalScsoApproval() {
        return finalScsoApproval;
    }

    public void setFinalScsoApproval(Boolean finalScsoApproval) {
        this.finalScsoApproval = finalScsoApproval;
    }
}
