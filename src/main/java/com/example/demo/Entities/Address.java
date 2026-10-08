package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "add_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @OneToOne
    @JoinColumn(name = "employee_info")
    private Employe employe;
}
