package com.andersen.training.crud.interfaces;

import com.andersen.training.crud.dto.UserDto;
import com.andersen.training.crud.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDestinationMapper {
    UserDestinationMapper MAPPER = Mappers.getMapper(UserDestinationMapper.class);

    @Mappings({
            @Mapping(target = "userId", source = "dto.id"),
            @Mapping(target = "username", source = "dto.username"),
            @Mapping(target = "password", source = "dto.password"),
            @Mapping(target = "authorities", source = "dto.authorities"),
            @Mapping(target = "accountNonExpired", source = "dto.accountNonExpired"),
            @Mapping(target = "accountNonLocked", source = "dto.accountNonLocked"),
            @Mapping(target = "credentialsNonExpired", source = "dto.credentialsNonExpired"),
            @Mapping(target = "enabled", source = "dto.enabled")
    })
    User UserDtoToUser(UserDto dto);

    @Mappings({
            @Mapping(source = "user.userId", target = "id"),
            @Mapping(source = "user.username", target = "username"),
            @Mapping(source = "user.password", target = "password"),
            @Mapping(source = "user.authorities", target = "authorities"),
            @Mapping(source = "user.accountNonExpired", target = "accountNonExpired"),
            @Mapping(source = "user.accountNonLocked", target = "accountNonLocked"),
            @Mapping(source = "user.credentialsNonExpired", target = "credentialsNonExpired"),
            @Mapping(source = "user.enabled", target = "enabled")
    })
    UserDto UserToUserDto(User user);
}
