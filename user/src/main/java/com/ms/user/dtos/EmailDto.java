package com.ms.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private UUID id;
    private String email;
    private String subject;
    private String text;
}
