package com.mousatech.inventoryservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String sku;
    private Integer quantity;
}
