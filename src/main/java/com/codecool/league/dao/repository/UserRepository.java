package com.codecool.league.dao.repository;

import com.codecool.league.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findDistinctByUsername(String username);
}
