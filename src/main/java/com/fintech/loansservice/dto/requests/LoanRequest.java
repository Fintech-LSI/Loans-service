package com.fintech.loansservice.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public record LoanRequest(
        Long userId,
        @NotNull
        String loanIntent,
        @NotNull
        String loanGrade,
        @NotNull
        Double loanAmount,
        @NotNull
        Double loanInterestRate,
        @NotNull
        Double loanPercentIncome,
        @NotNull
        String cbPersonDefaultOnFile,
        @NotNull
        Integer cbPersonCredHistLength
) {}