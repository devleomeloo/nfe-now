package com.melo.nfenow.controller;

import com.melo.nfenow.dto.InvoiceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Invoices")
public interface InvoiceControllerDocs {

    @ApiOperation(value = "Invoice creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success - Invoice created")
    })
    InvoiceDTO create(InvoiceDTO invoiceDTO);
}
