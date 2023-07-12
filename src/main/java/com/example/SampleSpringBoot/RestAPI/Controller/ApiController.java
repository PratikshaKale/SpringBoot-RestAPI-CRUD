package com.example.SampleSpringBoot.RestAPI.Controller;

import com.example.SampleSpringBoot.RestAPI.Model.User;
import com.example.SampleSpringBoot.RestAPI.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value="/users")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    @PostMapping(value="/save" )
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "saved.....";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id , @RequestBody User user){
        User updateUser=userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "updated.........";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser (@PathVariable long id ){
        User deleteUser=userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return " Delete user with id :"+id;
    }
}
