package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Invoice;
import com.posystem.posystem.entity.InvoiceItem;
import com.posystem.posystem.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return invoiceItemRepository.findAll();
    }

    @Override
    public InvoiceItem getInvoiceItemById(Long id) {
        return invoiceItemRepository.findById(id).orElse(null);
    }

    @Override
    public InvoiceItem createInvoiceItem(InvoiceItem invoice) {
        return invoiceItemRepository.save(invoice);
    }

    @Override
    public InvoiceItem updateInvoiceItem(Long id, InvoiceItem InvoiceItem) {
        return null;
    }

    @Override
    public void deleteInvoiceItem(Long id) {
        invoiceItemRepository.deleteById(id);
    }
}
