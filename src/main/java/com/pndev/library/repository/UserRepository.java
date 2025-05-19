package com.pndev.library.repository;

import com.pndev.library.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByRegistrationDateBetween(String startDate, String endDate);

    boolean existsByEmailAndIdNot(@NotBlank(message = "Email should not be blank") @Email(message = "Email should be valid") String email, Long id);
}
