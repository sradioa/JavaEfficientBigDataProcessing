package org.entlimsoft.bigdata.entity;

import org.entlimsoft.bigdata.to.ProductTO;

public class ProductEntity {

	private ProductTO productTO;

	public ProductEntity(Integer idProduct, String description, Double price, Integer stock) {

		this.productTO = new ProductTO(idProduct, description, price, stock);

	}
	
	public ProductEntity(ProductTO productTO) {

		this.productTO = productTO;

	}

	public ProductTO getProductTO() {
		return productTO;
	}

}
