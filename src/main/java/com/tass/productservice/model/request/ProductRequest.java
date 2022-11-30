package com.tass.productservice.model.request;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product_request")
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String barcode;
    private String name;
    private String image;
    private String description;
    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
