
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.entity.ClaimDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimDocumentRepository extends JpaRepository<ClaimDocument, Long> {
}
