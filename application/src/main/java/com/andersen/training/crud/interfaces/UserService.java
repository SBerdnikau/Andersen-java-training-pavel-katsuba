package com.andersen.training.crud.interfaces;

import com.andersen.training.crud.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<UserDto>, UserDetailsService {
}
