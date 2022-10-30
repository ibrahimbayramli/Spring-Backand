package com.ibrahimbayramli.backend.service;

import com.ibrahimbayramli.backend.dto.UserCreateDTO;
import com.ibrahimbayramli.backend.dto.UserUpdateDTO;
import com.ibrahimbayramli.backend.dto.UserViewDTO;

import java.util.List;

public interface UserService {
    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUsers();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);


    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
}
