package com.kth.sep.repository;

import com.kth.sep.entity.EventPlanningRequest;
import com.kth.sep.entity.RecruitmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruitmentRequestRepository extends JpaRepository<RecruitmentRequest, Integer> {
    Optional<RecruitmentRequest> findById(Integer id);

}
