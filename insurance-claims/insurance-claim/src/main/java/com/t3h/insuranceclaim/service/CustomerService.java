package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAll();
    CustomerDTO getById(Long id);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(Long id, CustomerDTO customerDTO);
    void delete(Long id);
}
