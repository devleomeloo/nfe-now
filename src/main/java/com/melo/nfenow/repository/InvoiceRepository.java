package com.melo.nfenow.repository;

import com.melo.nfenow.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findBySerialNumber(String serialNumber);
}
