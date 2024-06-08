package com.posystem.posystem.controller;

import com.posystem.posystem.Service.InvoiceItemService;
import com.posystem.posystem.entity.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/invoiceitems")
public class InvoiceItemController {
    @Autowired
    private InvoiceItemService invoiceItemService;

    @GetMapping
    public ResponseEntity<List<InvoiceItem>> getAllInvoices() {
        List<InvoiceItem> invoices = invoiceItemService.getAllInvoiceItems();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItem> getInvoiceById(@PathVariable Long id) {
        InvoiceItem invoice = invoiceItemService.getInvoiceItemById(id);
        if (invoice != null) {
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceItem> createInvoice(@RequestBody InvoiceItem invoice) {
        InvoiceItem createdInvoice = invoiceItemService.createInvoiceItem(invoice);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceItemService.deleteInvoiceItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
