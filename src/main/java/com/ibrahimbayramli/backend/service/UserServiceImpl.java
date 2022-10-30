package com.ibrahimbayramli.backend.service;

import com.ibrahimbayramli.backend.dto.UserCreateDTO;
import com.ibrahimbayramli.backend.dto.UserUpdateDTO;
import com.ibrahimbayramli.backend.dto.UserViewDTO;
import com.ibrahimbayramli.backend.exception.NotFoundException;
import com.ibrahimbayramli.backend.model.User;
import com.ibrahimbayramli.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
       final User user= userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {

        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.
                save(new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName(),userCreateDTO.getId()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user =userRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final User updatedUser=userRepository.save(user);
        return UserViewDTO.of(user);
    }


}
