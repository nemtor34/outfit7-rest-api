package com.fun7.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;


interface UserRepository extends JpaRepository<User, String> {
	
}