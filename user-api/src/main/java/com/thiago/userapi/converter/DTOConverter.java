package com.thiago.userapi.converter;

import com.thiago.shoppingclient.dto.UserDTO;
import com.thiago.userapi.model.User;

public class DTOConverter {

	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setKey(user.getKey());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		return userDTO;
	}

}
