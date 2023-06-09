package com.kuppiya.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;


    public Iterable<User> selectUser(){
        return ur.findAll();
    }

    public void saveUser(User user){
        ur.save(user);
    }

    public User findUser(Long id){
        return ur.findById(id).get();
    }

    public void deleteUser(Long id){
        ur.deleteById(id);
    }


}
