package com.posystem.posystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the item, using LAZY fetching for performance optimization
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Items item;

    // Quantity of the item in stock, must be non-null
    @Column(nullable = false)
    private int quantity;

    // Timestamp for when the stock was last updated, auto-generated
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    // Method to set the last updated timestamp before persisting or updating
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
