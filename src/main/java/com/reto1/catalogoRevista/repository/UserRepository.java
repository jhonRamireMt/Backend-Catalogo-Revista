package com.reto1.catalogoRevista.repository;

import com.reto1.catalogoRevista.model.User;
import com.reto1.catalogoRevista.repository.crud.UserRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserRepositoryCrud userRepositoryCrud;


    /*LISTAR CON LOS USUARIO REGISTRADOS*/
    public List<User> getUsers(){
        return (List<User>) userRepositoryCrud.findAll();
    }

    /*REGISTRAR UN USUARIO*/
    public User createUser(User user){
        return (User) userRepositoryCrud.save(user);
    }

    /*VALIDAR EXISTENCIA USUARIO POR EMAIL*/
    public boolean validateByEmail(String email){
       Optional<User> user = userRepositoryCrud.findByEmail(email);
       return user.isPresent();

    }

    /*VALIDAR EXISTENCIA USUARIO POR EMAIL/PASSWORD */
    public Optional<User> autenticarUsuarioByEmailAndPassword(String email, String password){
        return userRepositoryCrud.findByEmailAndPassword(email,password);
    }


}
