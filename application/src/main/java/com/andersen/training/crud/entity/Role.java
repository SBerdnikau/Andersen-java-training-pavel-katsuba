package com.andersen.training.crud.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ROLE")
public class Role extends Dictionary implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        Role thatRole = (Role) o;
        return this.getName().equals(thatRole.getName());
    }
}
