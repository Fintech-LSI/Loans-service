package com.fintech.loansservice.dto.responses;

import lombok.Builder;



@Builder
public record LoanResponse(
        Long id,
        Long userId,
        Integer personAge,
        Double personIncome,
        String personHomeOwnership,
        Integer personEmpLength,
        String loanIntent,
        String loanGrade,
        Double loanAmount,
        Double loanInterestRate,
        Integer loanStatus,
        Double loanPercentIncome,
        String cbPersonDefaultOnFile,
        Integer cbPersonCredHistLength
) {}