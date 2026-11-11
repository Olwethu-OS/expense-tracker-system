package com.olwethu.userservice.mapper;

import com.olwethu.userservice.dto.UserRequestDTO;
import com.olwethu.userservice.dto.UserResponseDTO;
import com.olwethu.userservice.model.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user)
    {
        UserResponseDTO userDTO= new UserResponseDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static User toModel(UserRequestDTO userRequestDTO)
    {
        User user=new User();
        user.setName(userRequestDTO.getName());
        user.setSurname(userRequestDTO.getSurname());
        user.setEmail(userRequestDTO.getEmail());
        return user;
    }
}
