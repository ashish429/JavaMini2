package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserGenderRepository extends JpaRepository<User, Integer> {
	@Query(value = "select count(name) as count, name ,gender from users", nativeQuery = true)
	User userGender(String name);
}
