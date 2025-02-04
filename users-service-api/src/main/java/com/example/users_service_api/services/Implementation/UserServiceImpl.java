package com.example.users_service_api.services.Implementation;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.commons.dtos.UpdateInfoRequest;
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
    public void updateUser(UpdateInfoRequest userRequest, String userId) {
            userRepository.findById(Long.valueOf(userId))
                    .map(userExists -> {
                        return updateFieldsUser(userExists, userRequest);
                    }).map(userRepository::save)
                    .orElseThrow(() -> new RuntimeException("Error updating User"));
    }

    private UserModel updateFieldsUser(UserModel existingUser, UpdateInfoRequest userModel) {
        existingUser.setName(userModel.getName());
        existingUser.setEmail(userModel.getEmail());
        return existingUser;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.findById(Long.valueOf(userId)).ifPresentOrElse(userRepository::delete, () -> {
            throw new RuntimeException("Error deleting User");
        });
    }

    @Override
    public UserModel getUser(String userId) {
        return Optional.of(Long.valueOf(userId)).flatMap(userRepository::findByUserId)
                .orElseThrow(() -> new RuntimeException("Error getting the User"));
    }
}
