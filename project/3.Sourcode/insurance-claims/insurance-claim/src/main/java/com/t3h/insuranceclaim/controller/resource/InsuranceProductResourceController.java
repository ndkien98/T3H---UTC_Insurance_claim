package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.InsuranceProductDTO;
import com.t3h.insuranceclaim.service.InsuranceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insuranceproducts")
public class InsuranceProductResourceController {

    @Autowired
    private InsuranceProductService insuranceproductService;

    @GetMapping
    public List<InsuranceProductDTO> getAll() {
        return insuranceproductService.getAll();
    }

    @GetMapping("/id")
    public InsuranceProductDTO getById(@PathVariable Long id) {
        return insuranceproductService.getById(id);
    }

    @PostMapping
    public InsuranceProductDTO create(@RequestBody InsuranceProductDTO insuranceproductDTO) {
        return insuranceproductService.create(insuranceproductDTO);
    }

    @PutMapping("/id")
    public InsuranceProductDTO update(@PathVariable Long id, @RequestBody InsuranceProductDTO insuranceproductDTO) {
        return insuranceproductService.update(id, insuranceproductDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        insuranceproductService.delete(id);
    }
}
