package com.ibrahimbayramli.backend.service;

import com.ibrahimbayramli.backend.dto.UserCreateDTO;
import com.ibrahimbayramli.backend.dto.UserViewDTO;
import com.ibrahimbayramli.backend.model.User;

public interface UserService {
    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);
}
