package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.ClaimDocumentDTO;
import com.t3h.insuranceclaim.service.ClaimDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claimdocuments")
public class ClaimDocumentResourceController {

    @Autowired
    private ClaimDocumentService claimdocumentService;

    @GetMapping
    public List<ClaimDocumentDTO> getAll() {
        return claimdocumentService.getAll();
    }

    @GetMapping("/id")
    public ClaimDocumentDTO getById(@PathVariable Long id) {
        return claimdocumentService.getById(id);
    }

    @PostMapping
    public ClaimDocumentDTO create(@RequestBody ClaimDocumentDTO claimdocumentDTO) {
        return claimdocumentService.create(claimdocumentDTO);
    }

    @PutMapping("/id")
    public ClaimDocumentDTO update(@PathVariable Long id, @RequestBody ClaimDocumentDTO claimdocumentDTO) {
        return claimdocumentService.update(id, claimdocumentDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        claimdocumentService.delete(id);
    }
}
