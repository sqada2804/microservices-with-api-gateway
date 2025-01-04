package com.example.users_service_api.controllers.Interface;

import com.example.users_service_api.dtos.UpdateInfoRequest;
import commons.UserModel;
import commons.apiPathConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(apiPathConstants.V1_ROUTE + apiPathConstants.USER_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IUserController {
        @GetMapping(value = "/getUser/{userId}")
        ResponseEntity<UserModel> getUser(@RequestHeader("X-User-Id") Long userId);

        @PutMapping(value = "/updateUser/{userId}")
        ResponseEntity<Void> updateUser(@RequestBody UpdateInfoRequest userRequest, @RequestHeader("X-User-Id") Long userId);

        @DeleteMapping(value = "/deleteUser/{userId}")
        ResponseEntity<Void> deleteUser(@RequestHeader("X-User-Id") Long userId);
}
