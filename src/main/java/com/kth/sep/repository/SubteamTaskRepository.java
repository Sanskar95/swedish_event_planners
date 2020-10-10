package com.kth.sep.repository;

import com.kth.sep.entity.FinancialRequest;
import com.kth.sep.entity.SubteamTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubteamTaskRepository extends JpaRepository<SubteamTask, Integer> {
    Optional<SubteamTask> findById(Integer id);

}
