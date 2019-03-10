package org.entlimsoft.bigdata.business;

import java.util.List;

import org.entlimsoft.bigdata.to.ProductTO;

public interface ProductGenerator {

	List<ProductTO> generateProducts(Integer quantity);

}