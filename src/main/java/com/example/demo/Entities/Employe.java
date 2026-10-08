package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emp_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
