package com.example.demo.Services;

import com.example.demo.Entities.Address;
import com.example.demo.Entities.Employe;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.EmployeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressServices addressServices;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(rollbackFor = Exception.class)
    public EmployeDto addEmployeWithAddress(String name, String addressText) {
        Employe employe = new Employe();
        employe.setName(name);
        Employe employeSaved = this.employeeRepository.save(employe);

        if ("error".equalsIgnoreCase(name)) {
            throw new RuntimeException("Simulim i gabimit! Transaksioni do te behet Rollback");
        }

        Address address = new Address();
        address.setAddress(addressText);
        address.setEmploye(employeSaved);
        Address savedAddress = this.addressServices.addAddress(address);

        EmployeDto employeeDto = modelMapper.map(employeSaved, EmployeDto.class);
        employeeDto.setAddress(modelMapper.map(savedAddress, AddressDto.class));
        return employeeDto;
    }
}
