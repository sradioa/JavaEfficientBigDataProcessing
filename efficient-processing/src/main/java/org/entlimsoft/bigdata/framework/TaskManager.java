package org.entlimsoft.bigdata.framework;

import java.util.concurrent.Executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class TaskManager {
	
	private static Executor executor = new ThreadPoolTaskExecutor(); 

}
