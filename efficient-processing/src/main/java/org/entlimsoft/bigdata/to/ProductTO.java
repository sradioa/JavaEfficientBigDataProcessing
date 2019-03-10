package org.entlimsoft.bigdata.to;

public class ProductTO {

	private Integer idProduct;
	private String description;
	private Double price;

	private Integer stock;

	public ProductTO(Integer idProduct, String description, Double price, Integer stock) {
		super();
		this.idProduct = idProduct;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductTO [");
		if (idProduct != null) {
			builder.append("idProduct=");
			builder.append(idProduct);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (price != null) {
			builder.append("price=");
			builder.append(price);
			builder.append(", ");
		}
		if (stock != null) {
			builder.append("stock=");
			builder.append(stock);
		}
		builder.append("]");
		return builder.toString();
	}

}
