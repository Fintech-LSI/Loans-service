package com.fintech.loansservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "loans")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    private Integer personAge;
    private Double personIncome;
    private String personHomeOwnership;
    private Integer personEmpLength;

    @Column(nullable = false)
    private String loanIntent;

    @Column(nullable = false)
    private String loanGrade;

    @Column(nullable = false)
    private Double loanAmount;

    @Column(nullable = false)
    private Double loanInterestRate;

    private Integer loanStatus;

    @Column(nullable = false)
    private Double loanPercentIncome;

    @Column(nullable = false)
    private String cbPersonDefaultOnFile;

    @Column(nullable = false)
    private Integer cbPersonCredHistLength;
}