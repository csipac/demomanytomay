package com.example.demo.Controller;

import com.example.demo.entity.Rol;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class RUserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping
    public List<User> getVideos(){
        return userRepository.findAll();
    }

    @PostMapping
    public User creaUser(@RequestBody User user, @RequestBody List<Rol> roles){
        return userRepository.save(user);

    }
}
