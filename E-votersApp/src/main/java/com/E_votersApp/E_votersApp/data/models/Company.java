package com.E_votersApp.E_votersApp.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company")
public class Company {
    @Id
    private Long companyId;
    private String name;
    private int noOfEmployee;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @OneToMany
    private List<Employee> employees;


}
