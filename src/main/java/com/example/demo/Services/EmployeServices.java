package com.example.demo.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Entities.Address;
import com.example.demo.Entities.Employe;
import com.example.demo.Repository.EmployeeRepository;
@Service
public class EmployeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressServices addressServices;

    @Transactional(rollbackFor = Exception.class)
    public Employe addEmployeWithAddress(String name,String addresss) throws Exception{
        Employe employe = new Employe();
        employe.setName(name);
        Employe employeSaved = this.employeeRepository.save(employe);

        if("error".equalsIgnoreCase(name)){
            throw new RuntimeException("Simulim i gabimit! Transaksioni do te behet Rollback");

        }

        Address address = new Address();
        address.setAddress(addresss);
        address.setEmploye(employeSaved);
        this.addressServices.addAddress(address);

        return employeSaved;
    }

}
