package com.packt.webstore.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple Iphone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processor");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch table with a quad-core Qualcomm Snapdragon S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productID) {
        Product productById = null;

        for(Product product : listOfProducts) {
            if(product != null && product.getProductId() != null && product.getProductId().equals(productID)) {
                productById = product;
                break;
            }
        }

        if(productById == null) {
            throw new ProductNotFoundException(productID);
        }

        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        for(Product product: listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();

        Set<String> criterias = filterParams.keySet();

        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if(criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();

        for(Product product : listOfProducts) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }

        return productsByManufacturer;
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
