package com.melo.nfenow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private String cnpj;
    private String address;
    private String businessName;
    private BigDecimal value;
    private String serialNumber;
}
