
package com.t3h.insuranceclaim.repository;

import com.t3h.insuranceclaim.dto.request.ClaimRequest;
import com.t3h.insuranceclaim.entity.ClaimEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {

    @Query("SELECT c FROM ClaimEntity c " +
            "WHERE (:#{#request.claimCode} = '' OR LOWER(c.code) LIKE LOWER(CONCAT('%', :#{#request.claimCode}, '%'))) " +
            "AND (:#{#request.statusCode} = '' OR c.claimStatusEntity.code = :#{#request.statusCode}) " +
            "AND (:#{#request.fromDateSearch} IS NULL OR c.claimDate >= :#{#request.fromDateSearch}) " +
            "AND (:#{#request.toDateSearch} IS NULL OR c.claimDate <= :#{#request.toDateSearch}) AND (c.deleted=false OR c.deleted is NULL) ")
    Page<ClaimEntity> findByCondition(@Param("request") ClaimRequest request, Pageable pageable);
}
