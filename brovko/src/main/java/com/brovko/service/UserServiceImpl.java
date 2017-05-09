package com.brovko.service;

import com.brovko.domain.Role;
import com.brovko.domain.User;
import com.brovko.repository.RoleRepository;
import com.brovko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        Set<Role> roleSet = new HashSet<Role>(roleRepository.findAll());
        Role role = null;
        for (Role r: roleSet) {
            if (r.equals("USER")){
                role = r;
            }
        }
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));

        if (role != null){
            user.getRoles().add(role);
        }
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
