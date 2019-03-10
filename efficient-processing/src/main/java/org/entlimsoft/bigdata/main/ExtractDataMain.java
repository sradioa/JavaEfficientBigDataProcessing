package org.entlimsoft.bigdata.main;

import java.util.List;

import org.entlimsoft.bigdata.app.AppConfig;
import org.entlimsoft.bigdata.dao.ProductSimpleDao;
import org.entlimsoft.bigdata.entity.ProductEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

public class ExtractDataMain {

	
	public static void main (String args[]) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		ProductSimpleDao pdd = context.getBean(ProductSimpleDao.class);
		
		StopWatch sw = new StopWatch("Proof");
		sw.start("FindAllSimple");
		List<ProductEntity> datos = pdd.findAll();
		sw.stop();
		
		System.out.println(sw.prettyPrint());
	}
}
