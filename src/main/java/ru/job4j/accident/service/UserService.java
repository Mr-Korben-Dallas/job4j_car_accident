package ru.job4j.accident.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    public void save(User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        repository.save(user);
    }
}
