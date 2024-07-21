
package com.t3h.insurance_claim.repository;

import com.t3h.insurance_claim.entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductRepository extends JpaRepository<InsuranceProduct, Long> {
}
