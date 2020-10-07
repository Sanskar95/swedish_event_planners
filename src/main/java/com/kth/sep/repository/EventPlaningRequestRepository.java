package com.kth.sep.repository;

import com.kth.sep.entity.EventPlanningRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventPlaningRequestRepository extends CrudRepository<EventPlanningRequest,Integer> {
    Optional<EventPlanningRequest> findById(Integer id);
}
