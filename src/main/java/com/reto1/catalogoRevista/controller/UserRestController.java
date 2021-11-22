package com.reto1.catalogoRevista.controller;

import com.reto1.catalogoRevista.model.User;
import com.reto1.catalogoRevista.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listarUsuarios(){
        return userService.getUsers();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public boolean validarEmail(@PathVariable("email") String email){
        return userService.validarEmail(email);
    }

    @GetMapping("/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email,password);
    }

}
