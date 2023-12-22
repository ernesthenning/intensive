package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User get(int id) throws SQLException, ClassNotFoundException {
        return repository.get(id);
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        repository.delete(id);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        repository.update(user);
    }

    public void create(User user) throws SQLException, ClassNotFoundException {
        repository.create(user);
    }

}
