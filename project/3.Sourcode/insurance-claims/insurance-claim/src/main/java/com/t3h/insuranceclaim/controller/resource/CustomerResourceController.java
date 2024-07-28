package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.CustomerDTO;
import com.t3h.insuranceclaim.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerResourceController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/id")
    public CustomerDTO getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @PutMapping("/id")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.update(id, customerDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
