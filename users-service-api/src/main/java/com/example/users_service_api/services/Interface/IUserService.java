package com.example.users_service_api.services.Interface;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.dtos.UpdateInfoRequest;


public interface IUserService {
    void updateUser(UpdateInfoRequest userRequest, Long userId);
    void deleteUser(Long userId);
    UserModel getUser(Long userId);
}
