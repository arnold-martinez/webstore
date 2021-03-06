package com.packt.webstore.exception;

public class CategoryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -694354952032299587L;

    private String category;

    public CategoryNotFoundException(String category) {
        this.category = category;
    }

    public String getProductId() {
        return category;
    }


}
