
package com.t3h.insurance_claim.repository;

import com.t3h.insurance_claim.entity.ClaimDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimDocumentRepository extends JpaRepository<ClaimDocument, Long> {
}
