package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Address;
import com.example.demo.Repository.AddressRepository;
@Service
public class AddressServices {

    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address){
        return this.addressRepository.save(address);
    }
}
