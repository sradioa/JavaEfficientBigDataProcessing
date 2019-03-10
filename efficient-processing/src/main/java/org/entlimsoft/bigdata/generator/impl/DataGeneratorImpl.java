package org.entlimsoft.bigdata.generator.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.entlimsoft.bigdata.generator.DataGenerator;
import org.springframework.stereotype.Component;

@Component
public class DataGeneratorImpl implements DataGenerator {
	
	private double lastGeneratedDouble = 0.00D;
	
	private Integer lastGeneratedInteger = Integer.valueOf(0);
	
	
	
	
	/* (non-Javadoc)
	 * @see org.entlimsoft.bigdata.main.DataGenerator#generateAlphanumeric(int)
	 */
	@Override
	public String generateAlphanumeric(int length) {
		 String generatedString = RandomStringUtils.randomAlphanumeric(length);
		 return generatedString;
	}
	
	/* (non-Javadoc)
	 * @see org.entlimsoft.bigdata.main.DataGenerator#generateRandomNumber(double, double)
	 */
	@Override
	public Double generateRandomNumber(double lower, double upper) {
		
		this.lastGeneratedDouble = ThreadLocalRandom.current().nextDouble(this.lastGeneratedDouble, upper);
		
		Double generatedNumber = Double.valueOf(this.lastGeneratedDouble) ;
		
		return generatedNumber;
	}
	
	/* (non-Javadoc)
	 * @see org.entlimsoft.bigdata.main.DataGenerator#generateRandomInteger(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer generateRandomInteger(Integer lower, Integer upper) {
		
		this.lastGeneratedInteger = ThreadLocalRandom.current().nextInt(this.lastGeneratedInteger, upper);
		
		Integer generatedNumber = lower + (this.lastGeneratedInteger * (upper - lower));
				
		return generatedNumber;
	}

}
