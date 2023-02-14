package com.melo.nfenow.service;

import com.melo.nfenow.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceDTO create(InvoiceDTO invoice);

    InvoiceDTO updateById(Long invoiceId, InvoiceDTO invoiceDTO);

    InvoiceDTO findById(Long invoiceId);

    List<InvoiceDTO> findAll();

    void delete(Long invoiceId);
}
