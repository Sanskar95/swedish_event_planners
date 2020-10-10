package com.kth.sep.repository;

import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.entity.FinancialRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinancialRequestRepository extends JpaRepository<FinancialRequest, Integer> {
    Optional<FinancialRequest> findById(Integer id);
}
