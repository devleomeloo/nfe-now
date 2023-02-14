package com.melo.nfenow.service;

import com.melo.nfenow.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceDTO create(InvoiceDTO invoice);

    InvoiceDTO findById(Long id);

    List<InvoiceDTO> findAll();

    void delete(Long id);
}
