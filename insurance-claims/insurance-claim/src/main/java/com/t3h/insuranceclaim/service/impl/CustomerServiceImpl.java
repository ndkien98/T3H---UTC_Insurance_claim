package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.CustomerDTO;
import com.t3h.insuranceclaim.entity.CustomerEntity;
import com.t3h.insuranceclaim.mapper.CustomerMapper;
import com.t3h.insuranceclaim.repository.CustomerRepository;
import com.t3h.insuranceclaim.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toDTO(customerEntity);
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        customerEntity = customerRepository.save(customerEntity);
        return customerMapper.toDTO(customerEntity);
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerEntity = customerMapper.toEntity(customerDTO);
        customerEntity = customerRepository.save(customerEntity);
        return customerMapper.toDTO(customerEntity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
