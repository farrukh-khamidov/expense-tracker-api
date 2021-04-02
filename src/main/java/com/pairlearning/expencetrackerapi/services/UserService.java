package com.pairlearning.expencetrackerapi.services;

import com.pairlearning.expencetrackerapi.entities.User;
import com.pairlearning.expencetrackerapi.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
