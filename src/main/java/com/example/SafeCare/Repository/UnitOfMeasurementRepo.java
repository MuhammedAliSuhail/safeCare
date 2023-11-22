package com.example.SafeCare.Repository;


import com.example.SafeCare.Entites.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasurementRepo extends JpaRepository<UnitOfMeasurement,Integer> {
}
