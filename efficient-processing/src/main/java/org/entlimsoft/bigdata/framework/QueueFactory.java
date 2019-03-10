package org.entlimsoft.bigdata.framework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueFactory {
	
	
	public static <T>  BlockingQueue<T> createQueue(int capacity) {
		return new ArrayBlockingQueue<T>(capacity);
	}

}