
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
