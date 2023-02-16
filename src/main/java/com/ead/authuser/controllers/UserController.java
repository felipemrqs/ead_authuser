package com.ead.authuser.controllers;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public ResponseEntity<List<UserModel>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @RequestMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID id){
        Optional<UserModel> userModel = userService.findById(id);
        if(userModel.isPresent()){
            return ResponseEntity.ok(userModel.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id){
        Optional<UserModel> userModel = userService.findById(id);
        if(userModel.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.ok("User deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
