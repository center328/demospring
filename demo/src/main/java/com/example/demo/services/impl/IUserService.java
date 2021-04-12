package com.example.demo.services.impl;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserService implements UserService {
	@Override
	public Optional<User> getUser(String email) {
		return Optional.empty();
	}

	@Override
	public Optional<User> getUser(Long id) {
		return Optional.empty();
	}
}
