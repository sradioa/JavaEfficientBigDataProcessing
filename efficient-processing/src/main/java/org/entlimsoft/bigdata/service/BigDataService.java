package org.entlimsoft.bigdata.service;

import java.util.List;

import org.entlimsoft.bigdata.to.ProductTO;
import org.springframework.transaction.annotation.Transactional;

public interface BigDataService {

	void populateProducts(List<ProductTO> randomProducts);

	List<ProductTO> monoThreadExtrator();

	List<ProductTO> multiThreadExtrator();

}