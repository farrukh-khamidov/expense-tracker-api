package com.pairlearning.expencetrackerapi.services.impl;

import com.pairlearning.expencetrackerapi.entities.User;
import com.pairlearning.expencetrackerapi.exceptions.EtAuthException;
import com.pairlearning.expencetrackerapi.repositories.UserRepository;
import com.pairlearning.expencetrackerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches()) throw new EtAuthException("Invalid email format");

        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)  throw new EtAuthException("Email already in use");

        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
