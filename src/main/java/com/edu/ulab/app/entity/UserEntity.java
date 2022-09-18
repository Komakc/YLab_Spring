package com.edu.ulab.app.entity;

import com.edu.ulab.app.dto.UserDto;
import lombok.Data;

@Data
public class UserEntity {
        private String fullName;
        private String title;
        private int age;

        public UserDto userEntityToUserDto(UserEntity userEntity) {
            if ( userEntity == null ) {
                return null;
            }

            UserDto userDto = new UserDto();

            userDto.setFullName( userEntity.getFullName() );
            userDto.setTitle( userEntity.getTitle() );
            userDto.setAge( userEntity.getAge() );

            return userDto;
        }

        public UserEntity userDtoToUserEntity(UserDto userDto) {
            if ( userDto == null ) {
                return null;
            }

            UserEntity userEntity = new UserEntity();

            userEntity.setFullName( userDto.getFullName() );
            userEntity.setTitle( userDto.getTitle() );
            userEntity.setAge( userDto.getAge() );

            return userEntity;
        }

}
