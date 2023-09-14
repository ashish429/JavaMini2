package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserNationalityRepository extends JpaRepository<User, Integer> {
	@Query(value = "select nationality as country_id, Count(query)/Count(nationality) as Probability from users where name=query", nativeQuery = true)

	User userNationality(String query);
}
