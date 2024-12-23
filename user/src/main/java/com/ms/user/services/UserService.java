package com.ms.user.services;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.mappers.UserMapper;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducers;
import com.ms.user.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducers userProducers;

    @Transactional
    public UserRecordDTO createUser(UserRecordDTO dto) {
        UserModel user = UserMapper.toModel(dto);
        UserModel savedUser = userRepository.save(user);
        userProducers.publishMessageEmail(savedUser);
        return UserMapper.toDTO(savedUser);
    }

    public UserRecordDTO getUserById(UUID id) {
        return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found")));

    }
}
