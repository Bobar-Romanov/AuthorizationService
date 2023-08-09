package com.Main.AuthorizationService.utils;

import com.Main.AuthorizationService.dto.UserDTO;
import com.Main.AuthorizationService.dto.UserRegistrationDTO;
import com.Main.AuthorizationService.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;


    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User toUser(UserRegistrationDTO userRegistrationDTO) {
        return modelMapper.map(userRegistrationDTO, User.class);
    }

    public UserDTO toUserDTO (User user) {
        return modelMapper.map(user, UserDTO.class);
    }


}
