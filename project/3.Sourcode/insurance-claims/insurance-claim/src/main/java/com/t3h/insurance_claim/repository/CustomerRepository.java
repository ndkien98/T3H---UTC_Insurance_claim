
package com.t3h.insurance_claim.repository;

import com.t3h.insurance_claim.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
