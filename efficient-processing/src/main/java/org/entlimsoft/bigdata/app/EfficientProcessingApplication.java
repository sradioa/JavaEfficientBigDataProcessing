package org.entlimsoft.bigdata.app;

import java.util.List;

import org.entlimsoft.bigdata.business.DataExtractorBusiness;
import org.entlimsoft.bigdata.business.ProductGenerator;
import org.entlimsoft.bigdata.entity.ProductEntity;
import org.entlimsoft.bigdata.service.BigDataService;
import org.entlimsoft.bigdata.to.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.util.StopWatch;

@SpringBootApplication(scanBasePackages = {"org.entlimsoft.bigdata.app"})
public class EfficientProcessingApplication implements ApplicationRunner {

	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		//new SpringApplication(primarySources)
		
		context = SpringApplication.run(EfficientProcessingApplication.class, args);
		
		proofs();

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	

		
	}
	
	
	public static void proofs() {
		
		BigDataService bds = context.getBean(BigDataService.class);
		
		
		ProductGenerator productGenerator = context.getBean(ProductGenerator.class);
		
		List<ProductTO> randomProducts = productGenerator.generateProducts(100000);
		
		StopWatch sw = new StopWatch("Proof");
		
		sw.start("populateProducts");
		bds.populateProducts(randomProducts);
		
		sw.stop();
		
		
		sw.start("monoThreadExtrator");
		List<ProductTO> datos = bds.monoThreadExtrator();
		sw.stop();
		
		System.out.println(String.format("Extraídos: %s", datos.size()));
		
		double throughput = Double.valueOf(datos.size()) / ((sw.getLastTaskTimeMillis() / Double.valueOf(1000)));
		
		System.out.println(sw.prettyPrint());
		System.out.println(String.format("Throughput: %8.4f beans/segundo", throughput));
		
	}

}