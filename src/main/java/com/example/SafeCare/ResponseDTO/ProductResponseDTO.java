package com.example.SafeCare.ResponseDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {




    private String productName;




    private String unitMasherment;


    private String category;

    private double purchasePrice;

    private double SellingPrice;

    private Integer reOrderLevel;

    private Integer MaxOrderLevel;
}
