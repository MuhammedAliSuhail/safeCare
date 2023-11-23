package com.example.SafeCare.Repository;


import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product where product_name=:productName",nativeQuery = true)
    Product findName(String productName);

}
