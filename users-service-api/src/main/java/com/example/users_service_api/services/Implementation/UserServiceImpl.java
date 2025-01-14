package com.example.users_service_api.services.Implementation;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.dtos.UpdateInfoRequest;
import com.example.users_service_api.repository.UserRepository;
import com.example.users_service_api.services.Interface.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(UpdateInfoRequest userRequest, Long userId) {
        Optional.of(userId)
                .map(this::getUser)
                .map(existingUser -> updateFieldsUser(existingUser, userRequest))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Couldn´t update user"));
    }

    private UserModel updateFieldsUser(UserModel existingUser, UpdateInfoRequest userModel) {
        existingUser.setName(userModel.getName());
        existingUser.setEmail(userModel.getEmail());
        return existingUser;
    }

    @Override
    public void deleteUser(Long userId) {
        Optional.of(userId).map(this::getUser)
                .ifPresent(userRepository::delete);
    }

    @Override
    public UserModel getUser(Long userId) {
        return Optional.of(userId).flatMap(userRepository::findById)
                .orElseThrow(() -> new RuntimeException("Error finding by id"));
    }
}
