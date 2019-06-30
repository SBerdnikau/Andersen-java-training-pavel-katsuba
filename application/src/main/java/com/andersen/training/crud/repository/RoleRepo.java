package com.andersen.training.crud.repository;

import com.andersen.training.crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
