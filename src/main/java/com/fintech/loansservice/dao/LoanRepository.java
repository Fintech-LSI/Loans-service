package com.fintech.loansservice.dao;

import com.fintech.loansservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public  interface  LoanRepository extends JpaRepository<Loan, Long> {
}
