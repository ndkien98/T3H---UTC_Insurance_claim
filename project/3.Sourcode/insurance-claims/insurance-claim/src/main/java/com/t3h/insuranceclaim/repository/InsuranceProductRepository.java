
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductRepository extends JpaRepository<InsuranceProduct, Long> {
}
