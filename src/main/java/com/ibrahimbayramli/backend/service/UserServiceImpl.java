package com.ibrahimbayramli.backend.service;

import com.ibrahimbayramli.backend.dto.UserViewDTO;
import com.ibrahimbayramli.backend.exception.NotFoundException;
import com.ibrahimbayramli.backend.model.User;
import com.ibrahimbayramli.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Override
    public UserViewDTO getUserById(Long id) {
       final User user= userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }
}
