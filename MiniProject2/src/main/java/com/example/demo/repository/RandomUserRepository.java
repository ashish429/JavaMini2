package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface RandomUserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from user ORDER BY RAND()" + "LIMIT 1", nativeQuery = true)

	User random(User user);
}
