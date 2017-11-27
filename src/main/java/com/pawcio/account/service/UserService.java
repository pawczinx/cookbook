package com.pawcio.account.service;


import com.pawcio.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
