package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.dto.request.ClaimRequest;
import com.t3h.insuranceclaim.dto.response.ResponsePage;
import com.t3h.insuranceclaim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimResourceController {

    @Autowired
    private ClaimService claimService;


    @GetMapping("/id")
    public ClaimDTO getById(@PathVariable Long id) {
        return claimService.getById(id);
    }

    @PutMapping("/id")
    public ClaimDTO update(@PathVariable Long id, @RequestBody ClaimDTO claimDTO) {
        return claimService.update(id, claimDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        claimService.delete(id);
    }

    @PostMapping()
    public ResponseEntity<ResponsePage<List<ClaimDTO>>> getClaims(@RequestBody ClaimRequest request, Pageable pageable) {
        ResponsePage<List<ClaimDTO>> responsePage = claimService.getAllClaims(request,pageable);
        return ResponseEntity.ok(responsePage);
    }
}
