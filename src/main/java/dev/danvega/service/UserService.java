package dev.danvega.service;

import dev.danvega.domain.User;
import dev.danvega.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    public UserService() {
        this.userRepository = null;
    }

     public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private final UserRepository userRepository;

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User save(@NonNull User user) {
        return userRepository.save(user);
    }

    public void save(@NonNull List<User> users) {
        userRepository.saveAll(users);
    }
}
