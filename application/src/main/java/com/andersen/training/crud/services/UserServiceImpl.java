package com.andersen.training.crud.services;

import com.andersen.training.crud.dto.UserDto;
import com.andersen.training.crud.entity.Role;
import com.andersen.training.crud.entity.User;
import com.andersen.training.crud.interfaces.UserService;
import com.andersen.training.crud.repository.RoleRepo;
import com.andersen.training.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepo roleRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepo roleRepo) {
        this.userRepository = userRepository;
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional
    public void create(UserDto dto) {
//        User user = UserDestinationMapper.MAPPER.UserDtoToUser(dto);
        User user = new User();
        user.setUserId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        Set<Role> roles = new HashSet<>(dto.getAuthorities());
        roles.addAll(roleRepo.findAll());
        user.setAuthorities(roles);
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> readAll() {
        List<UserDto> results = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            results.add(UserDto.builder()
                    .id(user.getUserId())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .accountNonExpired(user.isAccountNonExpired())
                    .accountNonLocked(user.isAccountNonLocked())
                    .authorities(new ArrayList<>(user.getAuthorities()))
                    .credentialsNonExpired(user.isCredentialsNonExpired())
                    .enabled(user.isEnabled()).build()
            );
        }
        return results;
//        return userRepository.findAll().stream()
//                .flatMap(user -> Stream.of(UserDestinationMapper.MAPPER.UserToUserDto(user)))
//                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserDto readById(int id) {
//        Optional<User> user = userRepository.findById(id);
//        return UserDestinationMapper.MAPPER.UserToUserDto(user.orElseThrow(() -> new IllegalArgumentException("there isn't user with id = " + id)));
    return null;
    }

    @Override
    @Transactional
    public void update(int id, UserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("there isn't user with id = " + id));
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(login).orElseThrow(
                () -> new UsernameNotFoundException("there isn't user with name = " + login));
//        List<Role> roles = roleRelatesDao.getBeans(reader.getId());
//        reader.setAuthorities(roles);
//        return UserDestinationMapper.MAPPER.UserToUserDto(user);
    return UserDto.builder()
            .id(user.getUserId())
            .username(user.getUsername())
            .password(user.getPassword())
            .accountNonExpired(user.isAccountNonExpired())
            .accountNonLocked(user.isAccountNonLocked())
            .authorities(new ArrayList<>(user.getAuthorities()))
            .credentialsNonExpired(user.isCredentialsNonExpired())
            .enabled(user.isEnabled()).build();
    }
}
