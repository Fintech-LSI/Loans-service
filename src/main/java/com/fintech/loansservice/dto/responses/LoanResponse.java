package com.fintech.loansservice.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record LoanResponse(
        @JsonProperty("loan_id")
        Long loanId,

        @JsonProperty("person_age")
        Integer personAge,

        @JsonProperty("person_income")
        Double personIncome,

        @JsonProperty("person_home_ownership")
        String personHomeOwnership,

        @JsonProperty("person_emp_length")
        Integer personEmpLength,

        @JsonProperty("loan_intent")
        String loanIntent,

        @JsonProperty("loan_grade")
        String loanGrade,

        @JsonProperty("loan_amnt")
        Double loanAmount,

        @JsonProperty("loan_int_rate")
        Double loanInterestRate,

        @JsonProperty("loan_status")
        Integer loanStatus,

        @JsonProperty("loan_percent_income")
        Double loanPercentIncome,

        @JsonProperty("cb_person_default_on_file")
        String cbPersonDefaultOnFile,

        @JsonProperty("cb_person_cred_hist_length")
        Integer cbPersonCredHistLength,

        @JsonProperty("probability_of_approval")
        Float probaApproval,

        @JsonProperty("probability_of_denial")
        Float probaDenial


) {}
