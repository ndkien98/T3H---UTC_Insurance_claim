package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<ClaimDTO> getAll() {
        return claimService.getAll();
    }

    @GetMapping("/id")
    public ClaimDTO getById(@PathVariable Long id) {
        return claimService.getById(id);
    }

    @PostMapping
    public ClaimDTO create(@RequestBody ClaimDTO claimDTO) {
        return claimService.create(claimDTO);
    }

    @PutMapping("/id")
    public ClaimDTO update(@PathVariable Long id, @RequestBody ClaimDTO claimDTO) {
        return claimService.update(id, claimDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        claimService.delete(id);
    }
}
