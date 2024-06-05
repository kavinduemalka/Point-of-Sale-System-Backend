package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Invoice;
import com.posystem.posystem.entity.InvoiceItem;
import com.posystem.posystem.repository.InvoiceItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceItemService {
    List<InvoiceItem> getAllInvoiceItems();

    InvoiceItem getInvoiceItemById(Long id);

    InvoiceItem createInvoiceItem(InvoiceItem invoiceItem);

    InvoiceItem updateInvoiceItem(Long id, InvoiceItem InvoiceItem);

    void deleteInvoiceItem(Long id);
}
