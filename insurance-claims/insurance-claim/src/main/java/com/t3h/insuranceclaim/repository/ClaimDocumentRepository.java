
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.ClaimDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimDocumentRepository extends JpaRepository<ClaimDocumentEntity, Long> {
}
