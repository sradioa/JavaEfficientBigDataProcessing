package org.entlimsoft.bigdata.app;

import javax.sql.DataSource;

import org.entlimsoft.bigdata.business.DataExtractorBusiness;
import org.entlimsoft.bigdata.business.ProductGenerator;
import org.entlimsoft.bigdata.business.impl.DataGeneratorBusinessImpl;
import org.entlimsoft.bigdata.dao.ProductDao;
import org.entlimsoft.bigdata.dao.ProductSimpleDao;
import org.entlimsoft.bigdata.generator.DataGenerator;
import org.entlimsoft.bigdata.generator.impl.DataGeneratorImpl;
import org.entlimsoft.bigdata.service.BigDataService;
import org.entlimsoft.bigdata.service.BigDataServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
	
	
	private DataSource datasource; 
	
	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		this.datasource =  DataSourceBuilder.create().build();
		return this.datasource;
	}
	
	@Bean(name = "productDao")
	public ProductDao createProductDao() {
		ProductSimpleDao psd = new ProductSimpleDao();
		psd.setDataSource(this.datasource);
		return psd;
	}
	
	@Bean(name = "dataExtractorBusiness")
	public DataExtractorBusiness createDataExtractor() {
		return new DataExtractorBusiness();
	}
	
	@Bean(name = "productGenerator")
	public ProductGenerator createProductGenerator() {
		return new DataGeneratorBusinessImpl();
	}
	
	@Bean(name = "dataGenerator")
	public DataGenerator createDataGenerator() {
		return new DataGeneratorImpl();
	}
	
	@Bean(name = "bidDataService")
	public BigDataService createBigDataService() {
		return new BigDataServiceImpl();
	}
	

}
