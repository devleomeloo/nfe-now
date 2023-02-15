package com.melo.nfenow.service;

import com.melo.nfenow.builder.InvoiceBuilder;
import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.entity.Invoice;
import com.melo.nfenow.mapper.InvoiceMapper;
import com.melo.nfenow.repository.InvoiceRepository;
import com.melo.nfenow.service.impl.InvoiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceTest {

    private final InvoiceMapper invoiceMapper = InvoiceMapper.INSTANCE;

    @Mock
    private InvoiceRepository invoiceRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    private InvoiceBuilder invoiceBuilder;

    @BeforeEach
    void setUp() {
        invoiceBuilder = InvoiceBuilder.builder().build();
    }

    @Test
    void testCreateNewInvoiceService() {

        //given
        InvoiceDTO expectedInvoiceToCreateDTO = invoiceBuilder.buildInvoiceDTO();
        Invoice expectedCreatedInvoice = invoiceMapper.toModel(expectedInvoiceToCreateDTO);

        //when
        when(invoiceRepository.save(any())).thenReturn(expectedCreatedInvoice);

        InvoiceDTO createdInvoiceDTO = invoiceService.create(expectedInvoiceToCreateDTO);

        //then
        assertThat(createdInvoiceDTO, is(equalTo(expectedInvoiceToCreateDTO)));
    }
}
