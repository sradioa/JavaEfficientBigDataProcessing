package org.entlimsoft.bigdata.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.entlimsoft.bigdata.business.ProductGenerator;
import org.entlimsoft.bigdata.generator.DataGenerator;
import org.entlimsoft.bigdata.to.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DataGeneratorBusinessImpl implements ProductGenerator {
	
	
	@Autowired
	private DataGenerator dataGenerator;

	/* (non-Javadoc)
	 * @see org.entlimsoft.bigdata.business.impl.ProductGenerator#generateProducts(java.lang.Integer)
	 */
	@Override
	public List<ProductTO> generateProducts(Integer quantity) {

		Assert.notNull(quantity, "El numero de elementos a generar no puede ser nulo");
		Assert.isTrue(quantity > 0, "El numero de elementos a generar debe ser mayor que cero");

		List<ProductTO> productos = new ArrayList<>(quantity);

		for (int i = 0; i < quantity; i++) {

			productos.add(new ProductTO(null, this.dataGenerator.generateAlphanumeric(20), this.dataGenerator.generateRandomNumber(0.00D, 9999999999999.99D),
					this.dataGenerator.generateRandomInteger(0, Integer.MAX_VALUE)));
		}

		return productos;

	}

}
