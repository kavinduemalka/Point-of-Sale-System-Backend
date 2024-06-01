package com.posystem.posystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Custom item ID, must be unique and non-null
    @Column(nullable = false, unique = true)
    private String itemId;

    // Item name, must be non-null
    @Column(nullable = false)
    private String itemName;

    // Price of the item, must be non-null
    @Column(nullable = false)
    private BigDecimal price;

    // Stock quantity of the item, must be non-null
    @Column(nullable = false)
    private Integer stockQuantity;

    // Reference to the item category, must be non-null
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ItemCategory itemCategory;

    // Timestamp for when the item was created, auto-generated and non-updatable
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Method to set the creation timestamp before persisting
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
