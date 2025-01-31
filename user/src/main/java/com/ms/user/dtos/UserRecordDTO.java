package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder

public record UserRecordDTO(

        UUID id,

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email
) {
}
