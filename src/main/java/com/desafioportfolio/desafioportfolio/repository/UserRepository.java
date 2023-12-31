package com.desafioportfolio.desafioportfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioportfolio.desafioportfolio.model.User;
import com.desafioportfolio.desafioportfolio.util.RoleEnum;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	List<User> findAll();

	User findByName(String username);

	User findByUsername(String username);
}
