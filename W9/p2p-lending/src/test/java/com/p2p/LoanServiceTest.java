package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import com.p2p.domain.*;
import com.p2p.service.*;

public class LoanServiceTest{
    @Test 

    void shouldRejectLoanWhenBorrowerNotVerified() {
    // =========================
    // Arrange (Initial Condition)
    // =========================
    // Borrower belum lolos proses KYC 
    Borrower borrower = new Borrower (false, 700);
    // Service untuk pengajuan loan 
    LoanService loanService = new LoanService();
    // jumlah pinjamnan valid 
    BigDecimal amount = BigDecimal.valueOf(1000);
    // =========================
    // Act (Action)
    // =========================
    // Borrower mencoba mengajukan loan
    assertThrows(IllegalArgumentException.class, () -> {
        loanService.createLoan(borrower, amount);
    });
    // =========================
    // Assert (Expected Result)
    // =========================
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        Borrower borrower = new Borrower(true, 800);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-100));
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
        // Arrange
        Borrower borrower = new Borrower (true, 900);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        assertNotNull(loan); // loan harus terbentuk
        assertEquals(Loan.Status.APPROVED, loan.getStatus()); 
    }

    @Test 
    void shouldRejectLoanWhencreditScoreLow(){
        // Arrange 
        Borrower borrower = new Borrower(false, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert 
        assertNotNull(loan);
        assertEquals(Loan.Status.REJECTED, loan.getStatus());;
    }
}