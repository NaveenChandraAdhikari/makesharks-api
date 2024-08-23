package com.example.makesharks_api.controller;

import com.example.makesharks_api.model.ManufacturingProcess;
import com.example.makesharks_api.model.NatureOfBusiness;
import lombok.Data;
//import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Data
public class SupplierQueryRequest {
    @NotNull(message = "Location is required")
    private String location;

    @NotNull(message = "Nature of business is required")
    private String natureOfBusiness;

    @NotNull(message = "Manufacturing process is required")
    private String manufacturingProcess;

    @Min(value = 0, message = "Page number must be non-negative")
    private int page;

    @Min(value = 1, message = "Page size must be at least 1")
    private int size;
}
