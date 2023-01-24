package com.fundamentosplatzi.springboot.fundamentos2.repository;

import com.fundamentosplatzi.springboot.fundamentos2.emtity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
