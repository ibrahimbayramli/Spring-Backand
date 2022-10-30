package com.ibrahimbayramli.backend.api;

import com.ibrahimbayramli.backend.dto.UserCreateDTO;
import com.ibrahimbayramli.backend.dto.UserUpdateDTO;
import com.ibrahimbayramli.backend.dto.UserViewDTO;
import com.ibrahimbayramli.backend.service.UserService;
import com.ibrahimbayramli.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {


    private final UserService userService;

    @GetMapping("/v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {

        final UserViewDTO user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers() {

        final List<UserViewDTO> users = userService.getUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {

        userService.createUser(userCreateDTO);

        return ResponseEntity.ok(new GenericResponse("User created."));

    }

    @PutMapping("/v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable Long id,@RequestBody UserUpdateDTO userUpdateDTO) {

        final UserViewDTO user=userService.updateUser(id,userUpdateDTO);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){

        userService.deleteUser(id);

        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }

}
