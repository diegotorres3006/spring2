package com.fundamentosplatzi.springboot.fundamentos2.repository;

import com.fundamentosplatzi.springboot.fundamentos2.emtity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
