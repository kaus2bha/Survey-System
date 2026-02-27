package com.abis.survay_system.repository;

import com.abis.survay_system.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("""
       SELECT DISTINCT q FROM Question q
       LEFT JOIN FETCH q.options
       WHERE q.survey.id = :surveyId
    """)
    List<Question> findBySurveyIdWithOptions(@Param("surveyId") Long surveyId);
}