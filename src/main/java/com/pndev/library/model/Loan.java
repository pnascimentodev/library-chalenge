package com.pndev.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Builder.Default
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate = LocalDate.now();

    @Column(name = "return_date")
    private LocalDate returnDate;

    @PrePersist
    public void prePersist() {
        if (loanDate == null) {
            loanDate = LocalDate.now();
        }
    }
}
