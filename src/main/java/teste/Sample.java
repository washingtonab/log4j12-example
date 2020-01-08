package teste;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class Sample {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Hello world");
		
		MDC.put("separator", "blablabla");
		
		Logger logger = Logger.getLogger(Sample.class);
		logger.info("hey");
		
		long end = System.currentTimeMillis();
		System.out.println("Tempo de processamento em milisegundos: " + (end - start));
	}

}
