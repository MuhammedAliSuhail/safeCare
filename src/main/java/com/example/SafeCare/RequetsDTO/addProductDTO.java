package com.example.SafeCare.RequetsDTO;


import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addProductDTO {


    private String productName;

    private double SellingPrice;

    private String unitMasherment;

    private String category;

    private double purchasePrice;

    private Integer reOrderLevel;

    private Integer MaxOrderLevel;
}
