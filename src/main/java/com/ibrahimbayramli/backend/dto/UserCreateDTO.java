package com.ibrahimbayramli.backend.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserCreateDTO {


    private Long id;
    private String firstName;
    private String lastName;


}
