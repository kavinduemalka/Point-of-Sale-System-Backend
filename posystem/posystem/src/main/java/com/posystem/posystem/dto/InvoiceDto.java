package com.posystem.posystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InvoiceDto {
    private Long id;
    private String invoiceId;
    private LocalDateTime createdAt;

}
