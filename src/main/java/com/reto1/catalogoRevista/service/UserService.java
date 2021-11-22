package com.reto1.catalogoRevista.service;

import com.reto1.catalogoRevista.model.User;
import com.reto1.catalogoRevista.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*Este metodo retornara una lista con todos los usuarios de la BD*/
    public List<User> getUsers() {
        return userRepository.getUsers();
    }


    /*Registrar Uusario*/
    public User createUser(User user){
        if(user.getId()==null){
            if(!userRepository.validateByEmail(user.getEmail())){
               userRepository.createUser(user);
            }else{
                return user;
            }
        }
        return user;
    }

    /*Si el email existe retorna true, de lo contrario re torna false*/
    public boolean validarEmail(String email){
        if(userRepository.validateByEmail(email)){
            return true;
        }
        return false;
    }

    /*se verifica la autenticacion - user.get() devuelve los datos ingresados
    * En caso de ser falso - se retorna un objeto con un nombre no definido*/
    public User autenticarUsuario(String email,String password){
        Optional<User> user = userRepository.autenticarUsuarioByEmailAndPassword(email,password);
        if(user.isPresent()){
            return user.get();
        }else{
            User usuario = new User(email,password,"NO DEFINIDO");
            return usuario;
        }
    }
}
