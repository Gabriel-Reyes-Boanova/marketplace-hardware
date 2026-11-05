package com.gabriel.marketplace.controller;

import com.gabriel.marketplace.dto.AppUserDTO.CreateRequest;
import com.gabriel.marketplace.dto.AppUserDTO.UserResponse;
import com.gabriel.marketplace.service.AppUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController {

    private AppUserService service;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateRequest request){
        UserResponse user = service.createUser(request);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.id())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }
}
