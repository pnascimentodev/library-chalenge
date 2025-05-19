package com.pndev.library.service;

import com.pndev.library.exceptions.BusinessRuleException;
import com.pndev.library.exceptions.ResourceNotFoundException;
import com.pndev.library.model.User;
import com.pndev.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
    }

    @org.springframework.transaction.annotation.Transactional
    public User save(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BusinessRuleException("User by email already exists");
        }
        return userRepository.save(user);
    }

    @org.springframework.transaction.annotation.Transactional
    public User update(User user) {
        if (userRepository.existsByEmailAndIdNot(user.getEmail(), user.getId())) {
            throw new BusinessRuleException("User by email already exists");
        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        throw new UnsupportedOperationException("Not implemented yet");
    }



}
