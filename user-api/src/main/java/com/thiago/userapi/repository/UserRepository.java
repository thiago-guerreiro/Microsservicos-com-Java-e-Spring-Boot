package com.thiago.userapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.userapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByCpf(String cpf);

	List<User> queryByNomeLike(String name);

}
