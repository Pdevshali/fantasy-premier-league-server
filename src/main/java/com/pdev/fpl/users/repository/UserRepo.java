package com.pdev.fpl.users.repository;

import com.pdev.fpl.users.entities.User;
import org.springframework.data.repository.Repository;

public interface UserRepo extends Repository<User, Long> {
}
