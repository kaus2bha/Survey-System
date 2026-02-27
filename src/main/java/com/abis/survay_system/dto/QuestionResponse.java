package com.abis.survay_system.dto;

import java.util.List;

public record QuestionResponse(Long id,
                               String text,
                               String type,
                               List<OptionResponse> options) {
}
