package com.melo.nfenow.controller;

import com.melo.nfenow.builder.InvoiceBuilder;
import com.melo.nfenow.dto.InvoiceDTO;
import com.melo.nfenow.service.InvoiceService;
import com.melo.nfenow.util.JsonConversionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class InvoiceControllerTest {

    private static final String INVOICE_API_URL_PATH = "/api/v1/invoices";
    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    private MockMvc mockMvc;

    private InvoiceBuilder invoiceBuilder;

    @BeforeEach
    void setUp() {
        invoiceBuilder = InvoiceBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(invoiceController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void testCreateNewInvoiceController() throws Exception {

        InvoiceDTO expectedCreatedInvoice = invoiceBuilder.buildInvoiceDTO();

        when(invoiceService.create(expectedCreatedInvoice))
                .thenReturn(expectedCreatedInvoice);

        mockMvc.perform(post(INVOICE_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonConversionUtils.asJsonString(expectedCreatedInvoice)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cnpj", is(expectedCreatedInvoice.getCnpj())))
                .andExpect(jsonPath("$.serialNumber", is(expectedCreatedInvoice.getSerialNumber())));
    }
}
