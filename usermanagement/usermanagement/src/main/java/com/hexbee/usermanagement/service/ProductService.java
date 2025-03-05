package com.hexbee.usermanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hexbee.usermanagement.dto.ProductDTO;
import com.hexbee.usermanagement.entity.ProductEntity;

@Service
public interface ProductService {

    ProductEntity updateProduct(int id, ProductDTO productDTO);

    Optional<ProductEntity> getProductById(Integer id);

    List<ProductEntity> getAllProducts();

    void deleteProduct(Integer id);

	ProductEntity createProduct(ProductDTO productDTO);

}
