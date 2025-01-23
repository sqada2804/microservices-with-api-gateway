package com.example.users_service_api.controllers.Interface;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.commons.dtos.constants.apiUserPathConstant;
import com.example.users_service_api.commons.dtos.UpdateInfoRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(apiUserPathConstant.V1_ROUTE + apiUserPathConstant.USER_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IUserController {
        @GetMapping(value = "/getUser")
        ResponseEntity<UserModel> getUser(
                @PathVariable("userId") Long userId,
                @RequestHeader("X-User-Id") String userIdAuth);

        @PutMapping(value = "/updateUser")
        ResponseEntity<Void> updateUser(
                @RequestBody UpdateInfoRequest userRequest,
                @PathVariable("userId") Long userId,
                @RequestHeader("X-User-Id") String userIdAuth
        );

        @DeleteMapping(value = "/deleteUser")
        ResponseEntity<Void> deleteUser(
                @PathVariable("userId") Long userId,
                @RequestHeader("X-User-Id") String userIdAuth);
}
