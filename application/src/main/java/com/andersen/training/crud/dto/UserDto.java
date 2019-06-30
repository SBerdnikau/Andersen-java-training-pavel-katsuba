package com.andersen.training.crud.dto;

import com.andersen.training.crud.entity.Role;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements UserDetails {
    private int id;
    private String username;
    private String password;
    private List<Role> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
