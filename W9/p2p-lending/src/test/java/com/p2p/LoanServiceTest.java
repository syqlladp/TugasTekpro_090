package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import com.p2p.domain.*;
import com.p2p.service.*;

public class LoanServiceTest{
    @Test 

    void shouldRejectLoanWhenBorrowerNotVerified() {

    // =====================================================
    // SCENARIO : 
    // Borrower tidak terverifikasi (KYC = false)
    // Ketika borrrower menunjukan pinjaman 
    // Maka sistem harus menolak dengan melempar exception 
    // =====================================================

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
}