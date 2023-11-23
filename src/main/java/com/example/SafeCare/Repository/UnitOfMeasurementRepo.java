package com.example.SafeCare.Repository;


import com.example.SafeCare.Entites.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UnitOfMeasurementRepo extends JpaRepository<UnitOfMeasurement,Integer> {

    @Query(value = "select * from unit_of_measurement where unit_of_measurement_name=:unitName",nativeQuery = true)
    UnitOfMeasurement findName(String unitName);




}

