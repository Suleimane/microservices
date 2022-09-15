package com.suleimane.hruser.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suleimane.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
