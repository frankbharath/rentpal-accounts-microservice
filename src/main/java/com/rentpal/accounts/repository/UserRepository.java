package com.rentpal.accounts.repository;

/*
 * @author frank
 * @created 12 Dec,2020 - 2:59 AM
 */

import com.rentpal.accounts.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
