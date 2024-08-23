package com.example.makesharks_api.controller;




import com.example.makesharks_api.dto.SupplierDTO;
import com.example.makesharks_api.service.SupplierService;
import com.example.makesharks_api.model.NatureOfBusiness;
import com.example.makesharks_api.model.ManufacturingProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<?> querySuppliers(@Valid @RequestBody SupplierQueryRequest request) {
        System.out.println("Received request: " + request);

        NatureOfBusiness natureOfBusiness = null;
        ManufacturingProcess manufacturingProcess = null;

        try {
            if (request.getNatureOfBusiness() != null && !request.getNatureOfBusiness().isEmpty()) {
                natureOfBusiness = NatureOfBusiness.valueOf(request.getNatureOfBusiness().toUpperCase());
            }
            if (request.getManufacturingProcess() != null && !request.getManufacturingProcess().isEmpty()) {
                manufacturingProcess = ManufacturingProcess.valueOf(request.getManufacturingProcess().toUpperCase());
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid enum value: " + e.getMessage());
        }

        Page<SupplierDTO> suppliersPage = supplierService.findSuppliers(
                request.getLocation(),
                natureOfBusiness,
                manufacturingProcess,
                request.getPage(),
                request.getSize()
        );

        List<SupplierDTO> suppliers = suppliersPage.getContent();

        System.out.println("Total elements: " + suppliersPage.getTotalElements());
        System.out.println("Total pages: " + suppliersPage.getTotalPages());
        System.out.println("Current page number: " + suppliersPage.getNumber());
        System.out.println("Suppliers found: " + suppliers.size());

        Map<String, Object> response = new HashMap<>();
        response.put("suppliers", suppliers);
        response.put("currentPage", suppliersPage.getNumber());
        response.put("totalItems", suppliersPage.getTotalElements());
        response.put("totalPages", suppliersPage.getTotalPages());

        return ResponseEntity.ok(response);
    }
}
//package com.example.makesharks_api.controller;
//
//
//import com.example.makesharks_api.model.Supplier;
//import com.example.makesharks_api.service.SupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//@RestController
//@RequestMapping("/api/supplier")
//public class SupplierController {
//
//    @Autowired
//    private SupplierService supplierService;
//
//    @PostMapping("/query")
//    public ResponseEntity<Page<Supplier>>querySuppliers(@Valid
//                                                            @RequestBody SupplierQueryRequest request ){
//
//    Page<Supplier>suppliers =supplierService.findSuppliers(
//            request.getLocation(),
//            request.getNatureOfBusiness(),
//            request.getManufacturingProcess(),
//            request.getPage(),
//            request.getSize()
//
//
//    );
//    return ResponseEntity.ok(suppliers);
//
//    }
//}
//
//
