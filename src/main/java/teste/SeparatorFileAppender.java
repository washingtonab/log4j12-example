package teste;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.MDC;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

public class SeparatorFileAppender extends FileAppender {

	private static final String ORIGINAL_FILE_NAME = "orginalLogFileName";
	private static final String SEPARATOR = "separator";

	public SeparatorFileAppender() {
	}

	public SeparatorFileAppender(Layout layout, String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException {
		super(layout, fileName, append, bufferedIO, bufferSize);
	}

	public SeparatorFileAppender(Layout layout, String fileName, boolean append) throws IOException {
		super(layout, fileName, append);
	}

	public SeparatorFileAppender(Layout layout, String fileName) throws IOException {
		super(layout, fileName);
	}

	@Override
	public void activateOptions() {
		MDC.put(ORIGINAL_FILE_NAME, fileName);
		super.activateOptions();
	}

	@Override
	public void append(LoggingEvent event) {
		try {
			String separator = (String) MDC.get(SEPARATOR);
			String originalFileName = (String) MDC.get(ORIGINAL_FILE_NAME);
			System.out.println(originalFileName);
			String newFileName = originalFileName.concat("."+separator);
			setFile(newFileName, fileAppend, bufferedIO, bufferSize);
		} catch (Exception e) {
			String message = "Error on separate log file";
			errorHandler.error(message, e, ErrorCode.FILE_OPEN_FAILURE);
		}
		super.append(event);
	}

}