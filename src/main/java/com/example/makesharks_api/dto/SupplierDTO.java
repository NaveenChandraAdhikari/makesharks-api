package com.example.makesharks_api.dto;

import com.example.makesharks_api.model.ManufacturingProcess;
import com.example.makesharks_api.model.NatureOfBusiness;
import lombok.Data;
import java.util.Set;

@Data
public class SupplierDTO {
    private Long supplierId;
    private String companyName;
    private String website;
    private String location;
    private NatureOfBusiness natureOfBusiness;
    private Set<ManufacturingProcess> manufacturingProcesses;
}
