

package com.lunna.insight.Core.log;


public interface InsightLogger {

    /**
     * Log the information message to the information configuration.
     *
     * @param message to log
     */
    void info(String message);


    /**
     * Log the information message to the information configuration.
     *
     * @param message   to log
     * @param throwable to show trace
     */
    void info(String message, Throwable throwable);

    /**
     * Log the error message to the error configuration.
     *
     * @param message to log
     */
    void error(String message);

    /**
     * Log the error message to the error configuration.
     *
     * @param message   to log
     * @param throwable to show trace
     */
    void error(String message, Throwable throwable);
}
