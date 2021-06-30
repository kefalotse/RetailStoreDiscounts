package com.retailstore.retailStoreDiscounts.service;

import com.retailstore.retailStoreDiscounts.exception.RecordNotFoundException;
import com.retailstore.retailStoreDiscounts.model.User;
import com.retailstore.retailStoreDiscounts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //create record
    public User createUpdateUser(User user) throws RecordNotFoundException
    {
        Optional<User> isuser = userRepository.findById(user.getUserId());
        if(isuser.isPresent())
        {
            User newuser = isuser.get();
            newuser.setUserType(user.getUserType());
            newuser.setFirstName(user.getFirstName());
            newuser.setLastName(user.getLastName());
            newuser.setCell_No(user.getCell_No());
            newuser.setRegistrationDate(user.getRegistrationDate());


            newuser = userRepository.save(newuser);
            return newuser;
        } else {
            user = userRepository.save(user);
            return user;
        }
    }//end create record
    //list all records
    public List<User> getAllUsers()
    {
        List<User> userList = userRepository.findAll();

        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }//end list all records




}
