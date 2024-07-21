
package com.t3h.insurance_claim.repository;

import com.t3h.insurance_claim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
