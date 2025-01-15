package com.example.users_service_api.controllers.Interface;

import com.example.common_library.entity.UserModel;
import com.example.users_service_api.constants.apiUserPathConstant;
import com.example.users_service_api.dtos.UpdateInfoRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(apiUserPathConstant.V1_ROUTE + apiUserPathConstant.USER_ROUTE)
@SecurityRequirement(name = "Bearer Token")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IUserController {
        @GetMapping(value = "/getUser")
        ResponseEntity<UserModel> getUser(@RequestHeader("X-User-Id") Long userId);

        @PutMapping(value = "/updateUser")
        ResponseEntity<Void> updateUser(@RequestBody UpdateInfoRequest userRequest, @RequestHeader("X-User-Id") Long userId);

        @DeleteMapping(value = "/deleteUser")
        ResponseEntity<Void> deleteUser(@RequestHeader("X-User-Id") Long userId);
}
