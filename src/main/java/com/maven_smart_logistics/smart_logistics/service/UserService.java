package com.maven_smart_logistics.smart_logistics.service;


import com.maven_smart_logistics.smart_logistics.model.User;
import com.maven_smart_logistics.smart_logistics.repository.RoleRepository;
import com.maven_smart_logistics.smart_logistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    public User getUserByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }


}
