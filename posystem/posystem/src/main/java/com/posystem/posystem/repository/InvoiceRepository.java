package com.posystem.posystem.repository;

import com.posystem.posystem.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT MAX(i.Id) FROM Invoice i")
    String findMaxInvoiceId();
}

