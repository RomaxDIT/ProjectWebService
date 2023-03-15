package com.mycompany.user;

import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
