package com.pairlearning.expencetrackerapi.repositories;

import com.pairlearning.expencetrackerapi.entities.User;
import com.pairlearning.expencetrackerapi.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
