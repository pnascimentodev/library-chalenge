package com.pndev.library.repository;

import com.pndev.library.model.Book;
import com.pndev.library.model.Loan;
import com.pndev.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByUser (User user);

    List<Loan> findByBook (Book book);

    Optional<Loan> findByBookAndReturnDateIsNull (Book book);

    @Query("SELECT l FROM Loan l WHERE l.returnDate IS NULL AND l.loanDate < :date")
    List<Loan> findOverdueLoans(@Param("date") LocalDate date);

    @Query("SELECT COUNT(l) FROM Loan l WHERE l.user = :user AND l.returnDate IS NULL")
    long countActiveLoansByUser(@Param("user") User user);

    List<Loan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

}
