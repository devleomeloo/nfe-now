package com.melo.nfenow.service.impl;

import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.entity.Invoice;
import com.melo.nfenow.exception.InvoiceAlreadyExistsException;
import com.melo.nfenow.mapper.InvoiceMapper;
import com.melo.nfenow.repository.InvoiceRepository;
import com.melo.nfenow.service.InvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final InvoiceMapper invoiceMapper = InvoiceMapper.INSTANCE;
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    @Override
    public InvoiceDTO create(InvoiceDTO invoice) {
        verifyIfExists(invoice.getSerialNumber());

        Invoice invoiceToCreate = invoiceMapper.toModel(invoice);
        Invoice createdInvoice = invoiceRepository.save(invoiceToCreate);

        return invoiceMapper.toDTO(createdInvoice);
    }

    private void verifyIfExists(String serialNumber) {
        invoiceRepository.findBySerialNumber(serialNumber)
                .ifPresent(author -> {throw new InvoiceAlreadyExistsException(serialNumber); });
    }
}
