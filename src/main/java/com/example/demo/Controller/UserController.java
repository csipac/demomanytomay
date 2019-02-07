package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("usuario", new User());
        model.addAttribute("usuariosList", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "index";
    }

    @PostMapping
    public String createUser(Model model, User user){
        userRepository.save(user);
        model.addAttribute("usuario", new User());
        model.addAttribute("usuariosList", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "index";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editUser(Model model, @PathVariable(name = "id") Long id){
        User user = userRepository.findById(id).get();
        model.addAttribute("usuario", user);
        model.addAttribute("usuariosList", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable(name = "id") Long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        model.addAttribute("usuario", new User());
        model.addAttribute("usuariosList", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "index";
    }
}
