package com.melo.nfenow.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_nota")
    private Long noteNumber;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "endereco")
    private String address;

    @Column(name = "razao_social")
    private String businessName;

    @Column(name = "valor")
    private BigDecimal value;

    @Column(name = "numero_serie")
    private String serialNumber;
}