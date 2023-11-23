package com.example.SafeCare.Entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasurement {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer UnitOfMeasurementId;


//    @Column(unique = true)
    private String  UnitOfMeasurementName;

//    @OneToMany(mappedBy = "unitMasherment",cascade = CascadeType.ALL)
//    List<Product> productList=new ArrayList<>();

}
