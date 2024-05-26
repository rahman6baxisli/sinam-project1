package com.sinam.sinamproject.service;

import com.sinam.sinamproject.entity.User;


public interface UserService {

    User findUserByFin( String fin);
    User registerUser(User user);

}
