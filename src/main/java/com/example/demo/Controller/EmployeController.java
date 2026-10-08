package com.example.demo.Controller;
import com.example.demo.Services.EmployeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping({"/api/employe", "/api/employee"})
public class EmployeController {

    @Autowired
    private EmployeServices employeServices;

    @PostMapping("/add")
        public ResponseEntity<?> saveEmploye(@RequestBody Map<String,String > payload){
        try{
            String name = payload.get("name");
            String address = payload.get("address");
            var result = employeServices.addEmployeWithAddress(name,address);
            return ResponseEntity.ok(Map.of("status","success","message","Punonjesi u ruajt me sukses","data",result));

        }catch (Exception e){
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Ndodhi nje gabim";
            return ResponseEntity.badRequest().body(Map.of("status", "error", "message", errorMessage));
        }
        }
}
