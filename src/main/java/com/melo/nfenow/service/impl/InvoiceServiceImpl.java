package com.melo.nfenow.service.impl;

import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.entity.Invoice;
import com.melo.nfenow.exception.InvoiceAlreadyExistsException;
import com.melo.nfenow.exception.InvoiceNotFoundException;
import com.melo.nfenow.mapper.InvoiceMapper;
import com.melo.nfenow.repository.InvoiceRepository;
import com.melo.nfenow.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public InvoiceDTO findById(Long id){
        return invoiceMapper.toDTO(verifyAndGetIfExists(id));
    }

    public List<InvoiceDTO> findAll(){
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDTO)
                .toList();
    }

    public void delete(Long id){
        verifyAndGetIfExists(id);
        invoiceRepository.deleteById(id);
    }

    private void verifyIfExists(String serialNumber) {
        invoiceRepository.findBySerialNumber(serialNumber)
                .ifPresent(invoice -> {throw new InvoiceAlreadyExistsException(serialNumber); });
    }

    public Invoice verifyAndGetIfExists(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }
}
