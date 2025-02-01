package com.hexbee.usermanagement.serviceIMPL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hexbee.usermanagement.Repository.ProductRepository;
import com.hexbee.usermanagement.Repository.UserRepository;
import com.hexbee.usermanagement.dto.ProductDTO;
import com.hexbee.usermanagement.entity.ProductEntity;
import com.hexbee.usermanagement.service.ProductService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity product = new ProductEntity();
        product.setName(productDTO.getName());
        product.setPricePerUnit(productDTO.getPricePerUnit());
        product.setUnit(productDTO.getUnit());
        product.setCgst(productDTO.getCgst());
        product.setSgst(productDTO.getSgst());
        product.setStock(productDTO.getStock());
        product.setHsnsac(productDTO.getHsnsac());
        
        product.setCreatedBy(userRepository.findById(productDTO.getCreatedBy()) 
            .orElseThrow(() -> new RuntimeException("User not found")));
        
        ProductEntity savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public ProductEntity updateProduct(int id, ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPricePerUnit(productDTO.getPricePerUnit());
        product.setUnit(productDTO.getUnit());
        product.setCgst(productDTO.getCgst());
        product.setSgst(productDTO.getSgst());
        product.setStock(productDTO.getStock());
        product.setHsnsac(productDTO.getHsnsac());
        product.setUpdatedAt(LocalDateTime.now());
        ProductEntity updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public Optional<ProductEntity> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
