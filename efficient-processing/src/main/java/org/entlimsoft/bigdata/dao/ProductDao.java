package org.entlimsoft.bigdata.dao;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.entlimsoft.bigdata.entity.ProductEntity;

public interface ProductDao {

	List<ProductEntity> findAll();

	BlockingQueue<ProductEntity> getAllQueue();
	
	int[] insertProducts(List<ProductEntity> products);

}
