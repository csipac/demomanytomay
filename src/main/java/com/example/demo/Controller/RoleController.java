package com.example.demo.Controller;

import com.example.demo.entity.Rol;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<Rol> getRole(){
        return roleRepository.findAll();
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol){
        return roleRepository.save(rol);
    }
}
