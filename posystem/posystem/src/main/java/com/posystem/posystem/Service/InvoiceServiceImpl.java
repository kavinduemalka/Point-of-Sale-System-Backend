package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Invoice;
import com.posystem.posystem.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        return optionalInvoice.orElse(null);
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Optional<Invoice> optionalExistingInvoice = invoiceRepository.findById(id);
        if (optionalExistingInvoice.isPresent()) {
            Invoice existingInvoice = optionalExistingInvoice.get();
            // Update existing invoice fields
            existingInvoice.setUser(invoice.getUser());
            //existingInvoice.setItems(invoice.getItems());
            return invoiceRepository.save(existingInvoice);
        } else {
            return null; // or throw Exception
        }
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Long generateInvoiceId() {
        long maxId = Long.parseLong(invoiceRepository.findMaxInvoiceId());
        return maxId;
    }
}
