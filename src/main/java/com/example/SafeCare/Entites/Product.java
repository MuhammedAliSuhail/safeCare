package com.example.SafeCare.Entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ProductId;


    @Column(nullable = false)
    private String productName;


  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name ="unitOfMeasurement")
    private UnitOfMeasurement unitMasherment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="category")
    private Category category;

    private double purchasePrice;

    private double SellingPrice;

    private Integer reOrderLevel;

    private Integer MaxOrderLevel;
}
