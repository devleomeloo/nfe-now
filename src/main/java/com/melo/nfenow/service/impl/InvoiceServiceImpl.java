package com.melo.nfenow.service.impl;

import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.entity.Invoice;
import com.melo.nfenow.exception.InvoiceAlreadyExistsException;
import com.melo.nfenow.exception.InvoiceNotFoundException;
import com.melo.nfenow.mapper.InvoiceMapper;
import com.melo.nfenow.repository.InvoiceRepository;
import com.melo.nfenow.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
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

    public InvoiceDTO updateById(Long invoiceId, InvoiceDTO invoiceDTO) {
        Invoice foundInvoice = verifyAndGetIfExists(invoiceId);
        Invoice invoiceToUpdate = invoiceMapper.toModel(invoiceDTO);

        invoiceToUpdate.setNoteNumber(foundInvoice.getNoteNumber());
        invoiceToUpdate.setCnpj(invoiceDTO.getCnpj());
        invoiceToUpdate.setAddress(invoiceDTO.getAddress());
        invoiceToUpdate.setBusinessName(invoiceDTO.getBusinessName());
        invoiceToUpdate.setValue(invoiceDTO.getValue());
        invoiceToUpdate.setSerialNumber(invoiceDTO.getSerialNumber());
        Invoice updatedInvoice = invoiceRepository.save(invoiceToUpdate);

        return invoiceMapper.toDTO(updatedInvoice);
    }

    public InvoiceDTO findById(Long invoiceId) {
        return invoiceMapper.toDTO(verifyAndGetIfExists(invoiceId));
    }

    public List<InvoiceDTO> findAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDTO)
                .toList();
    }

    public void delete(Long invoiceId) {
        verifyAndGetIfExists(invoiceId);
        invoiceRepository.deleteById(invoiceId);
    }

    private void verifyIfExists(String serialNumber) {
        invoiceRepository.findBySerialNumber(serialNumber)
                .ifPresent(invoice -> {
                    throw new InvoiceAlreadyExistsException(serialNumber);
                });
    }

    public Invoice verifyAndGetIfExists(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotFoundException(invoiceId));
    }
}
