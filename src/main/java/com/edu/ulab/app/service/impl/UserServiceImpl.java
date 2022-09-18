package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.UserEntity;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static long id = 0L;

    @Override
    public UserDto createUser(UserDto userDto) {
        id++;

        UserEntity userEntity = new UserEntity();
        userEntity.userDtoToUserEntity(userDto);
        Storage.addUser(id, userEntity);

        userDto.setId(id);

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.userDtoToUserEntity(userDto);

        return userEntity.userEntityToUserDto(Storage.updateUser(userDto.getId(), userEntity));
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = userEntity.userEntityToUserDto(Storage.getUserById(id));
        userDto.setId(id);

        return userDto;
    }

    @Override
    public void deleteUserById(Long id) {
        Storage.deleteUserById(id);
    }
}
