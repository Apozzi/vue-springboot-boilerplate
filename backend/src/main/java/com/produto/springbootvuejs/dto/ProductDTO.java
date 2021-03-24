package com.produto.springbootvuejs.dto;

import java.math.BigDecimal;

public class ProductDTO {

    private String description;
    private String productType;
    private BigDecimal supplierPrice;
    private Integer amount;

    protected ProductDTO() {}

    public ProductDTO(String description, String productType, BigDecimal supplierPrice, Integer amount) {
        this.description = description;
        this.productType = productType;
        this.supplierPrice = supplierPrice;
        this.amount = amount;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(BigDecimal supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
