package com.melo.nfenow.controller;

import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController implements InvoiceControllerDocs{

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceDTO create(
            @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.create(invoiceDTO);
    }

    @GetMapping("{id}")
    public InvoiceDTO findById(@PathVariable Long id) {
        return invoiceService.findById(id);
    }

    @GetMapping
    public List<InvoiceDTO> findAll() {
        return invoiceService.findAll();
    }

}
