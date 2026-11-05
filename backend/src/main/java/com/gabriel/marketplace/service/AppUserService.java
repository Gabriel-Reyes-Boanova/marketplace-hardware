package com.gabriel.marketplace.service;

import com.gabriel.marketplace.dto.AppUserDTO.*;
import com.gabriel.marketplace.entity.AppUser;
import com.gabriel.marketplace.exception.UserExistsException;
import com.gabriel.marketplace.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService {

    private AppUserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse createUser(CreateRequest request) throws UserExistsException{
        if(repository.existsByEmail(request.email())) throw new UserExistsException("Usuario ja esta cadastrado");

        String hash = passwordEncoder.encode(request.password());

        AppUser user = AppUser.builder()
                .name(request.name())
                .email(request.email())
                .passwordHash(hash)
                .roles(request.role())
                .build();

        AppUser saveUser = repository.save(user);

        return new UserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail(),
                saveUser.getRoles(),
                saveUser.isActive());
    }
}
