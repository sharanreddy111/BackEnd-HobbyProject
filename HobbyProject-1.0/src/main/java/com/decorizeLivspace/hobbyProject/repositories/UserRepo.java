package com.decorizeLivspace.hobbyProject.repositories;

import java.util.Optional;

import com.decorizeLivspace.hobbyProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
		
	
	Optional<User> findByEmail(String email);
}
