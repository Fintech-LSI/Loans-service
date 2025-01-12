package com.fintech.loansservice.controller;

import com.fintech.loansservice.dto.requests.LoanRequest;
import com.fintech.loansservice.dto.responses.LoanResponse;
import com.fintech.loansservice.entity.Loan;
import com.fintech.loansservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@RequestBody LoanRequest request) {
        Loan loan = loanService.createLoan(request);
        return ResponseEntity.ok(toLoanResponse(loan));
    }

    private LoanResponse toLoanResponse(Loan loan) {
        return LoanResponse.builder()
                .id(loan.getId())
                .userId(loan.getUserId())
                .personAge(loan.getPersonAge())
                .personIncome(loan.getPersonIncome())
                .personHomeOwnership(loan.getPersonHomeOwnership())
                .personEmpLength(loan.getPersonEmpLength())
                .loanIntent(loan.getLoanIntent())
                .loanGrade(loan.getLoanGrade())
                .loanAmount(loan.getLoanAmount())
                .loanInterestRate(loan.getLoanInterestRate())
                .loanStatus(loan.getLoanStatus())
                .loanPercentIncome(loan.getLoanPercentIncome())
                .cbPersonDefaultOnFile(loan.getCbPersonDefaultOnFile())
                .cbPersonCredHistLength(loan.getCbPersonCredHistLength())
                .build();
    }
}