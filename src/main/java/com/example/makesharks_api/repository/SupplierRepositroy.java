package com.example.makesharks_api.repository;


import com.example.makesharks_api.model.ManufacturingProcess;
import com.example.makesharks_api.model.NatureOfBusiness;
import com.example.makesharks_api.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

//right imports are important dude:)
@Repository
public interface SupplierRepositroy extends JpaRepository<Supplier, Long> {
    @Query("SELECT DISTINCT s FROM Supplier s LEFT JOIN s.manufacturingProcesses mp WHERE " +
            "(:location IS NULL OR s.location = :location) AND " +
            "(:natureOfBusiness IS NULL OR s.natureOfBusiness = :natureOfBusiness) AND " +
            "(:manufacturingProcess IS NULL OR mp = :manufacturingProcess)")
    Page<Supplier> findSuppliers(
            @Param("location") String location,
            @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
            @Param("manufacturingProcess") ManufacturingProcess manufacturingProcess,
            Pageable pageable
    );

}

