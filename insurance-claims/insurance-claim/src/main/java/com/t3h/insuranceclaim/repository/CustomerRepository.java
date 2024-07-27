
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
