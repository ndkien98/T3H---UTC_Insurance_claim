package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.ClaimStatusDTO;
import com.t3h.insuranceclaim.service.ClaimStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claimstatuss")
public class ClaimStatusResourceController {

    @Autowired
    private ClaimStatusService claimstatusService;

    @GetMapping
    public List<ClaimStatusDTO> getAll() {
        return claimstatusService.getAll();
    }

    @GetMapping("/id")
    public ClaimStatusDTO getById(@PathVariable Long id) {
        return claimstatusService.getById(id);
    }

    @PostMapping
    public ClaimStatusDTO create(@RequestBody ClaimStatusDTO claimstatusDTO) {
        return claimstatusService.create(claimstatusDTO);
    }

    @PutMapping("/id")
    public ClaimStatusDTO update(@PathVariable Long id, @RequestBody ClaimStatusDTO claimstatusDTO) {
        return claimstatusService.update(id, claimstatusDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        claimstatusService.delete(id);
    }
}
