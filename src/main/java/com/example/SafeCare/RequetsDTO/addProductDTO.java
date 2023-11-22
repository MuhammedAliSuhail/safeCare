package com.example.SafeCare.RequetsDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addProductDTO {


    private String productName;
    private double SellingPrice;
}
