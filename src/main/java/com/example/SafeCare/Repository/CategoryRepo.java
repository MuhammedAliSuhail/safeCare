package com.example.SafeCare.Repository;


import com.example.SafeCare.Entites.Category;
import com.example.SafeCare.Entites.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    @Query(value = "select * from category where category_name=:CategoryName",nativeQuery = true)
    Category findName(String CategoryName);
}
