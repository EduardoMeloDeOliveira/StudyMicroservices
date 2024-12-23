package com.ms.user.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String email;
}
