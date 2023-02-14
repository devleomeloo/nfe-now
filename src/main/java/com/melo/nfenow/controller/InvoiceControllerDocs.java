package com.melo.nfenow.controller;

import com.melo.nfenow.dto.InvoiceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Invoices")
public interface InvoiceControllerDocs {

    @ApiOperation(value = "Invoice creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success - Invoice created")
    })
    InvoiceDTO create(InvoiceDTO invoiceDTO);

    @ApiOperation(value = "Find Invoice by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success - Invoice found"),
            @ApiResponse(code = 404, message = "Invoice not found error code ")
    })
    InvoiceDTO findById(Long id);

    @ApiOperation(value = "List all invoices registered")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all registered invoices")
    })
    List<InvoiceDTO> findAll();

    @ApiOperation(value = "Delete Invoice by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Invoice deleted"),
            @ApiResponse(code = 404, message = "Invoice not found error code ")
    })
    void delete(Long id);
}
