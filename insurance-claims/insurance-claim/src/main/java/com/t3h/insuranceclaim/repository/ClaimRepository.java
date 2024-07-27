
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
