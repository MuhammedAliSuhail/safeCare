package com.example.SafeCare.Entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasurement {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer UnitOfMeasurementId;

    private String  UnitOfMeasurementName;

//    @OneToMany(mappedBy = "unitMasherment",cascade = CascadeType.ALL)
//    List<Product> productList=new ArrayList<>();

}
