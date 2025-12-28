package com.E_votersApp.E_votersApp.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAdminResponse {
    private Long id;
    private String username;
    private String password;
}
