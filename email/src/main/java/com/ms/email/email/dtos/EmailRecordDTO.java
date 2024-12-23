package com.ms.email.email.dtos;

import java.util.UUID;

public record EmailRecordDTO(
        UUID userId,
        String email,
        String subject,
        String text

) {
}
