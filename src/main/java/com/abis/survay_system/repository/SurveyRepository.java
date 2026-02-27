package com.abis.survay_system.repository;

import com.abis.survay_system.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findByActiveTrue();
    @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.questions q LEFT JOIN FETCH q.options WHERE s.id = :id")
    Survey findByIdWithQuestionsAndOptions(@Param("id") Long id);
}
