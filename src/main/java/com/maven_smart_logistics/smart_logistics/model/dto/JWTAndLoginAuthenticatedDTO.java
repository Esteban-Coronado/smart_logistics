package com.maven_smart_logistics.smart_logistics.model.dto;




import com.maven_smart_logistics.smart_logistics.model.Role;
import com.maven_smart_logistics.smart_logistics.model.User;

import java.util.List;


public record JWTAndLoginAuthenticatedDTO(
        Long id,
        String username,
        List<String> roles,
        String jwtToken

) {
    public JWTAndLoginAuthenticatedDTO(User user, String jwtToken)
    {
        this(user.getId(), user.getUsername(), user.getRoles().stream().map(Role::getName).toList(), jwtToken);
    }
}
