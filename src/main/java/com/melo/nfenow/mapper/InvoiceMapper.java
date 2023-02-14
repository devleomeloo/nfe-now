package com.melo.nfenow.mapper;

import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
    Invoice toModel(InvoiceDTO invoiceDTO);
    InvoiceDTO toDTO(Invoice invoice);
}