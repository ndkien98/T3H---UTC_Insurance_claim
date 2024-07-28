package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
