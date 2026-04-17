package dev.danvega.repository;

import dev.danvega.domain.User;
import dev.danvega.service.UserService;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User save(List<UserService> users);

}
