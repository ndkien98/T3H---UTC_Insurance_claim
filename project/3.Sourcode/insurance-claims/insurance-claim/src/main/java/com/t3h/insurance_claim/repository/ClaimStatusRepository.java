
package com.t3h.insurance_claim.repository;

import com.t3h.insurance_claim.entity.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimStatusRepository extends JpaRepository<ClaimStatus, Long> {
}
