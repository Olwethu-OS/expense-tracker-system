package com.olwethu.userservice.service;

import com.olwethu.userservice.dto.UserRequestDTO;
import com.olwethu.userservice.dto.UserResponseDTO;
import com.olwethu.userservice.mapper.UserMapper;
import com.olwethu.userservice.model.User;
import com.olwethu.userservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserResponseDTO addUser(UserRequestDTO userDTO)
    {
        User user=userRepo.save(UserMapper.toModel(userDTO));
       return UserMapper.toDTO(user);

    }
    public List<UserResponseDTO> getAll(){

        List<User> users=  userRepo.findAll();
        List<UserResponseDTO> userDTO=users
                .stream().map(user-> UserMapper.toDTO(user)).toList();
        return userDTO;
    }
    public User editUser(Long id,User newUser)
    {
      User existingUser=userRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found with ID: " + id));
        existingUser.setEmail(newUser.getEmail());
        existingUser.setName(newUser.getName());
        existingUser.setSurname(newUser.getEmail());
        return userRepo.save(existingUser);
    }
    public void delete(Long id)
    {
        userRepo.deleteById(id);
    }

}
