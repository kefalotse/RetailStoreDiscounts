package com.retailstore.retailStoreDiscounts.controller;

import com.retailstore.retailStoreDiscounts.model.User;
import com.retailstore.retailStoreDiscounts.repository.UserRepository;
import com.retailstore.retailStoreDiscounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person/")
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("user/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            User _user= userRepository.save(new User(user.getUserId(),user.getUserType(),user.getFirstName(),user.getLastName(),
                    user.getCell_No(),user.getRegistrationDate()));

            return  new ResponseEntity<>(_user, HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping("/person/list")
    public List<User> getAllPeople(){
        return userService.getAllUsers();
    }


}
