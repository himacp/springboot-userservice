



package com.stackroute.controller;
import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user")
    //@RequestMapping (path = "/something", method = RequestMethod.PUT)
    public ResponseEntity<?> savedUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);

    }}
