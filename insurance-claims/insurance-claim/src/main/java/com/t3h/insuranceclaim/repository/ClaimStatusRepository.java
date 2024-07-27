
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.ClaimStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimStatusRepository extends JpaRepository<ClaimStatusEntity, Long> {
}
