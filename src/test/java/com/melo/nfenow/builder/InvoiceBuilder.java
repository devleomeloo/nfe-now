package com.melo.nfenow.builder;

import com.melo.nfenow.dto.InvoiceDTO;
import lombok.Builder;
import java.math.BigDecimal;

@Builder
public class InvoiceBuilder {

    @Builder.Default
    private Long noteNumber = 1910L;

    @Builder.Default
    private String cnpj = "92832104590001";

    @Builder.Default
    private String address = "Rua São Jorge 1910";

    @Builder.Default
    private String businessName = "Beesby LTDA";

    @Builder.Default
    private BigDecimal value = new BigDecimal("987.38");

    @Builder.Default
    private String serialNumber = "1971";

    public InvoiceDTO buildInvoiceDTO(){

        return new InvoiceDTO(noteNumber, cnpj, address, businessName, value, serialNumber);
    }
}
