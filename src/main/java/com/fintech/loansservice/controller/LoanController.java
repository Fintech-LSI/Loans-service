package com.fintech.loansservice.controller;

import com.fintech.loansservice.dto.requests.LoanRequest;
import com.fintech.loansservice.dto.responses.LoanResponse;
import com.fintech.loansservice.entity.Loan;
import com.fintech.loansservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin("*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@RequestBody LoanRequest request) {
        Loan loan = loanService.createLoan(request);
        return ResponseEntity.ok(toLoanResponse(loan));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        List<LoanResponse> loanResponses = loans.stream()
                .map(this::toLoanResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(loanResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        return ResponseEntity.ok(toLoanResponse(loan));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanResponse>> getLoansByUserId(@PathVariable Long userId) {
        List<Loan> loans = loanService.getLoansByUserId(userId);
        List<LoanResponse> loanResponses = loans.stream()
                .map(this::toLoanResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(loanResponses);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, String>> updateLoanStatus(
            @PathVariable Long id,
            @RequestParam Integer status,
            @RequestParam Float probaApproval,
            @RequestParam Float probaDenial) {
        loanService.updateLoanStatus(id, status, probaApproval, probaDenial);
        Map<String, String> response = new HashMap<>();
        response.put("loan_status", String.valueOf(status));
        response.put("probaApproval", String.format("%.2f%%", probaApproval * 100));
        response.put("probaDenial", String.format("%.2f%%", probaDenial * 100));
        return ResponseEntity.ok(response);
    }


    private LoanResponse toLoanResponse(Loan loan) {
        return LoanResponse.builder()
                .loanId(loan.getId())
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
                .probaApproval(loan.getProbaApproval())
                .probaDenial(loan.getProbaDenial())
                .build();
    }
}