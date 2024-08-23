package com.example.makesharks_api.service;


import com.example.makesharks_api.dto.SupplierDTO;
import com.example.makesharks_api.model.Supplier;
import com.example.makesharks_api.model.NatureOfBusiness;
import com.example.makesharks_api.model.ManufacturingProcess;
//import com.example.makesharks_api.repository.SupplierRepository;
import com.example.makesharks_api.repository.SupplierRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepositroy supplierRepository;

    public Page<SupplierDTO> findSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, pageRequest)
                .map(supplier -> {
                    SupplierDTO dto = new SupplierDTO();
                    dto.setSupplierId(supplier.getSupplierId());
                    dto.setCompanyName(supplier.getCompanyName());
                    dto.setWebsite(supplier.getWebsite());
                    dto.setLocation(supplier.getLocation());
                    dto.setNatureOfBusiness(supplier.getNatureOfBusiness());
                    dto.setManufacturingProcesses(
                            supplier.getManufacturingProcesses()
                    );
                    return dto;
                });
    }
}

//@Service
//public class SupplierService {
//    @Autowired
//    private SupplierRepositroy supplierRepository;
//
//    public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess, int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, pageRequest);
//    }
//}
