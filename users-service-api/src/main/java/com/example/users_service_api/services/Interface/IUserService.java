package com.example.users_service_api.services.Interface;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.commons.dtos.UpdateInfoRequest;

public interface IUserService {
    void updateUser(UpdateInfoRequest userRequest, String userId);
    void deleteUser(String userId);
    UserModel getUser(String userId);
}
