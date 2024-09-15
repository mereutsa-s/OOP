package src.main.java.org.example.oop7;

import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void log(String message){
        logger.info(message);
    }
}
