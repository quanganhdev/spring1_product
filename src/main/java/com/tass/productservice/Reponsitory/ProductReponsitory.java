package com.tass.productservice.Reponsitory;

import com.tass.productservice.model.request.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductReponsitory extends JpaRepository<ProductRequest, Long> {
Optional<ProductRequest>findByBarcode(String barcode);
}
