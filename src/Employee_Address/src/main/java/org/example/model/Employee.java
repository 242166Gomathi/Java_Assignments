package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
//@ApiModel(description = "Employee details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated employee ID")
    private Long id;

//    @ApiModelProperty(notes = "Employee's name")
    private String name;

//    @ApiModelProperty(notes = "Employee's department")
    private String department;

//    @ApiModelProperty(notes = "Employee's salary")
    private double salary;

//    @ApiModelProperty(notes = "Employee's skill")
    private String skill;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference // Indicates that this field should be serialized
//    @ApiModelProperty(notes = "Employee's addresses")
    private List<Address> addresses = new ArrayList<>();

    public Employee(Long id, String name, String department, double salary, String skill, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skill = skill;
        this.addresses = addresses;
    }
}
