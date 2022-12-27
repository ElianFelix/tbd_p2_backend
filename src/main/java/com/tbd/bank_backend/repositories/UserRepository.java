package com.tbd.bank_backend.repositories;

import com.tbd.bank_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}