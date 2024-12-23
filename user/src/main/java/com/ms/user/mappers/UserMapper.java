package com.ms.user.mappers;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;

public class UserMapper {

    public static UserModel toModel(UserRecordDTO dto) {
        return UserModel.builder()
                .id(null)
                .email(dto.email())
                .name(dto.name())
                .build();
    }


    public static UserRecordDTO toDTO(UserModel model) {
        return UserRecordDTO.builder()
                .id(model.getId())
                .email(model.getEmail())
                .name(model.getName())
                .build();
    }


}
