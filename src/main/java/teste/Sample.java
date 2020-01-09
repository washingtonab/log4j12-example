package teste;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class Sample {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Hello world");

		MDC.put("separator", "000");
		Logger logger = Logger.getLogger(Sample.class);
		logger.info(Thread.currentThread().getName());

		
		new Thread(
				new Runnable() {
					public void run() {
						MDC.put("separator", "123");
						Logger logger = Logger.getLogger(Sample.class);
						logger.info(Thread.currentThread().getName());
					}
				}
		).start();
		

		new Thread(
				new Runnable() {
					public void run() {
						MDC.put("separator", "456");
						Logger logger = Logger.getLogger(Sample.class);
						logger.info(Thread.currentThread().getName());
					}
				}
		).start();

		
		long end = System.currentTimeMillis();
		System.out.println("Tempo de processamento em milisegundos: " + (end - start));
	}

}
