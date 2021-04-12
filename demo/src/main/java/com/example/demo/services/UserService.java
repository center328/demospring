package com.example.demo.services;

import com.example.demo.models.User;

import java.util.Optional;

public interface UserService {
	Optional<User> getUser(String email);
	Optional<User> getUser(Long id);
}
