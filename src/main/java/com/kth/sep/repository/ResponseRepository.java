package com.kth.sep.repository;

import com.kth.sep.entity.RecruitmentRequest;
import com.kth.sep.entity.reply.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response, Integer> {
    Optional<Response> findById(Integer id);

}
