package org.entlimsoft.bigdata.business;

import java.util.ArrayList;
import java.util.List;

import org.entlimsoft.bigdata.dao.ProductDao;
import org.entlimsoft.bigdata.entity.ProductEntity;
import org.entlimsoft.bigdata.to.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataExtractorBusiness {
	
	
	@Autowired
	private ProductDao productDao;
	
	
	
	public Integer insertProducts(List<ProductTO> products) {
		
		List<ProductEntity> entities = new ArrayList<>();
		
		products.forEach(product -> entities.add(new ProductEntity(product)));
		
		int[] result = productDao.insertProducts(entities);
		return result.length;
	}
	
	
	public List<ProductTO> monoThreadExtrator() {
		
		List<ProductTO> result = new ArrayList<>();
		
		productDao.findAll().forEach(entity -> result.add(entity.getProductTO()));
		
		return result;
	}
	
	public List<ProductEntity> multiThreadExtrator() {
		List<ProductEntity> result = new ArrayList<>();
		return result;
		
	}


}
