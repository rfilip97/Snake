package SnakeSRC;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Logger {
	private static Logger logger = new Logger();

	enum LogLevels {
		ERROR, WARNING, INFO, DEBUG
	}

	private LogLevels logLevel;

	private Logger() {
		logLevel = LogLevels.INFO;
	}

	public static Logger getInstance() {
		return logger;
	}

	public void setLogLevel(LogLevels logLevel) {
		this.logLevel = logLevel;
	}

	public void log(String message) {
		log(LogLevels.INFO, message);
	}

	public void log(LogLevels logLevel, String message) {
		if (checkLogCondition(logLevel)) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss - ").format(new Date());
			System.out.println(timeStamp + message);
		}
	}

	private Boolean checkLogCondition(LogLevels logLevel) {
		switch (this.logLevel) {
		case ERROR:
			if (logLevel == LogLevels.ERROR)
				return true;
			break;
		case WARNING:
			if (Arrays.asList(LogLevels.ERROR, LogLevels.WARNING).contains(logLevel))
				return true;
			break;
		case INFO:
			if (Arrays.asList(LogLevels.ERROR, LogLevels.WARNING, LogLevels.INFO).contains(logLevel))
				return true;
			break;
		case DEBUG:
			return true;
		default:
			return false;
		}

		return false;
	}
}
