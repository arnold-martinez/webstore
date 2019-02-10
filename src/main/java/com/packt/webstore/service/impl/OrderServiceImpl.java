package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.repository.ProductRepository;
import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("Out of Stock. Available Units in Stock" + productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
}