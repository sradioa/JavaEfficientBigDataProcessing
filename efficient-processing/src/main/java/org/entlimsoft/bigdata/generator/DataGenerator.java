package org.entlimsoft.bigdata.generator;

public interface DataGenerator {

	String generateAlphanumeric(int length);

	Double generateRandomNumber(double lower, double upper);

	Integer generateRandomInteger(Integer lower, Integer upper);

}