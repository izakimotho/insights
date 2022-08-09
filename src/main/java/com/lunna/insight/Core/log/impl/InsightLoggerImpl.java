
package com.lunna.insight.Core.log.impl;


import com.lunna.insight.Core.log.InsightLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Kushal
 * @Created On 3/27/2015.
 */
public class InsightLoggerImpl implements InsightLogger {
    Logger logger;

    public InsightLoggerImpl(Class aClass) {
        logger = LoggerFactory.getLogger(aClass);
    }

    /**
     * Log the information message to the information configuration.
     *
     * @param message to log
     */
    @Override
    public void info(String message) {
        logger.info(message);
    }

    /**
     * Log the information message to the information configuration.
     *
     * @param message   to log
     * @param throwable to show trace
     */
    @Override
    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    /**
     * Log the error message to the error configuration.
     *
     * @param message to log
     */
    @Override
    public void error(String message) {
        logger.error(message);
    }

    /**
     * Log the error message to the error configuration.
     *
     * @param message   to log
     * @param throwable to show trace
     */
    @Override
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
