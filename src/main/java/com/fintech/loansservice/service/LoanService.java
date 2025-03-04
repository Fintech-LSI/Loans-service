package com.fintech.loansservice.service;

import com.fintech.loansservice.dao.LoanRepository;
import com.fintech.loansservice.dto.UserDTO;
import com.fintech.loansservice.dto.requests.LoanRequest;
import com.fintech.loansservice.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public Loan createLoan(LoanRequest request) {
        // Fetch user data from User microservice
        UserDTO userDTO = restTemplate.getForObject(
                userServiceUrl + "/api/users/" + request.userId(),
                UserDTO.class
        );
        System.out.println(userDTO);

        // Create loan entity with combined data
        assert userDTO != null;
        Loan loan = Loan.builder()
                .userId(request.userId())
                .personIncome(userDTO.getSalary())
                .personAge(userDTO.getAge())
                .personHomeOwnership(userDTO.getHomeOwnership())
                .personEmpLength(userDTO.getEmploymentMonth())
                .loanIntent(request.loanIntent())
                .loanGrade(request.loanGrade())
                .loanAmount(request.loanAmount())
                .loanInterestRate(request.loanInterestRate())
                .loanPercentIncome(request.loanPercentIncome())
                .cbPersonDefaultOnFile(request.cbPersonDefaultOnFile())
                .cbPersonCredHistLength(request.cbPersonCredHistLength())
                .build();
        System.out.println(loan);
        return loanRepository.save(loan);
    }

    public Loan getLoanById(Long id) {
        Optional<Loan> loanOptional = loanRepository.findById(id);
        return loanOptional.orElseThrow(() -> new RuntimeException("Loan not found with ID: " + id));
    }


    public void updateLoanStatus(Long id, Integer status, Float probaApproval, Float probaDenial) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));

        if (status != 0 && status != 1) {
            throw new IllegalArgumentException("Invalid status. Status must be 0 or 1.");
        }
        loan.setLoanStatus(status);
        loan.setProbaApproval(probaApproval);
        loan.setProbaDenial(probaDenial);
        loanRepository.save(loan);
    }
    public List<Loan> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Add other service methods as needed
}