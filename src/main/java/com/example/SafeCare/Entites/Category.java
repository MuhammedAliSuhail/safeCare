package com.example.SafeCare.Entites;


import com.example.SafeCare.Entites.Product;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryId;


    @Column(unique = true)
    private String CategoryName;


////    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
////    List<Product> productList=new ArrayList<>();

}
