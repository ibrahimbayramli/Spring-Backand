package com.ibrahimbayramli.backend.api;

import com.ibrahimbayramli.backend.dto.UserViewDTO;
import com.ibrahimbayramli.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {


    private final UserService userService;

    @GetMapping("/v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {

        final UserViewDTO user=userService.getUserById(id);

        return ResponseEntity.ok(user);
    }
}
