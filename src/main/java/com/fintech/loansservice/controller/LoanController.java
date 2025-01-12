package com.fintech.loansservice.controller;

import com.fintech.loansservice.dto.requests.LoanRequest;
import com.fintech.loansservice.dto.responses.LoanResponse;
import com.fintech.loansservice.entity.Loan;
import com.fintech.loansservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        return ResponseEntity.ok(toLoanResponse(loan));
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateLoanStatus(@PathVariable Long id, @RequestParam Integer status) {
        loanService.updateLoanStatus(id, status);
        return ResponseEntity.ok("Loan status updated successfully.");
    }

    private LoanResponse toLoanResponse(Loan loan) {
        return LoanResponse.builder()


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