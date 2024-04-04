package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
//@ApiModel(description = "Address details")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated address ID")
    private Long addressId;

//    @ApiModelProperty(notes = "Address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference // Indicates that this field should not be serialized
    private Employee employee;
}
