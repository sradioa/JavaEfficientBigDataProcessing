package org.entlimsoft.bigdata.service;

import java.util.List;

import org.entlimsoft.bigdata.business.DataExtractorBusiness;
import org.entlimsoft.bigdata.business.ProductGenerator;
import org.entlimsoft.bigdata.to.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BigDataServiceImpl implements BigDataService {
	
	@Autowired
	private DataExtractorBusiness deb;
	
	
	
	/* (non-Javadoc)
	 * @see org.entlimsoft.bigdata.service.BigDataService#populateProducts(java.util.List)
	 */
	@Override
	@Transactional
	public void populateProducts(List<ProductTO> randomProducts){
		 
		this.deb.insertProducts(randomProducts);
		
	}
	
	@Override
	@Transactional
	public List<ProductTO> monoThreadExtrator() {
		return deb.monoThreadExtrator();
	}
	
	
	@Override
	@Transactional
	public List<ProductTO> multiThreadExtrator() {
		return deb.monoThreadExtrator();
	}
	

}
