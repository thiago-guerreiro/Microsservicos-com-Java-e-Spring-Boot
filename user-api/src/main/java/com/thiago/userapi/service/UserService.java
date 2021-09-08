package com.thiago.userapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.shoppingclient.dto.UserDTO;
import com.thiago.userapi.converter.DTOConverter;
import com.thiago.userapi.model.User;
import com.thiago.userapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}

	public UserDTO findById(long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		if (usuario.isPresent()) {
			return DTOConverter.convert(usuario.get());
		}
		return null;
	}

	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return DTOConverter.convert(user);
	}

	public UserDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		return null;
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return DTOConverter.convert(user);
		}
		return null;
	}

	public List<UserDTO> queryByName(String name) {
		List<User> usuarios = userRepository.queryByNomeLike(name);
		return usuarios.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}

}