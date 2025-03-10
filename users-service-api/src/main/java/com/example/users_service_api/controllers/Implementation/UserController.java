package com.example.users_service_api.controllers.Implementation;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.controllers.Interface.IUserController;
import com.example.users_service_api.commons.dtos.UpdateInfoRequest;
import com.example.users_service_api.services.Interface.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<Void> updateUser(UpdateInfoRequest userModel, String userId) {
        userService.updateUser(userModel,userId);
        return ResponseEntity.noContent().build();

    }
    @Override
    public ResponseEntity<UserModel> getUser(String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<Void> deleteUser(String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
