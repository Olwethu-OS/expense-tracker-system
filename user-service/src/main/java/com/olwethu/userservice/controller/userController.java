package com.olwethu.userservice.controller;

import com.olwethu.userservice.dto.UserRequestDTO;
import com.olwethu.userservice.dto.UserResponseDTO;
import com.olwethu.userservice.model.User;
import com.olwethu.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {

private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    private ResponseEntity<UserResponseDTO> insertUser(@Valid @RequestBody UserRequestDTO userRequestDTO){

        return ResponseEntity.ok().body(userService.addUser(userRequestDTO));

    }
    @GetMapping("/getAll")
    private ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAll());
    }
    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable Long id)
    {
        userService.delete(id);
    }

    @PutMapping("/editUser/{id}")
    private ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user)
    {
       return ResponseEntity.ok( userService.editUser(id,user));
    }
}
