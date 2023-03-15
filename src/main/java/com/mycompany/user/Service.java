package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Service {
    @Autowired private Repository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws NotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NotFoundException("Не удалось найти пользователей с идентификатором " + id);
    }

    public void delete(Integer id) throws NotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new NotFoundException("Не удалось найти пользователей с идентификатором " + id);
        }
        repo.deleteById(id);
    }
}
