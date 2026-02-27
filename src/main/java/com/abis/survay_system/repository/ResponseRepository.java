package com.abis.survay_system.repository;

import com.abis.survay_system.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<UserResponse, Long> {
}