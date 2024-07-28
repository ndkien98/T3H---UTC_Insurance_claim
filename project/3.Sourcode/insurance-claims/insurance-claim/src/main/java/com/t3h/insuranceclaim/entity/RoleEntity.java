package com.t3h.insuranceclaim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    private String name;
    private String code;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

}
