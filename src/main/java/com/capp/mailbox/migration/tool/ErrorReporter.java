package com.capp.mailbox.migration.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * @author mucahit.yilmaz
 */
final class ErrorReporter {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorReporter.class);
    private static final ErrorReporter ERROR_REPORTER = new ErrorReporter();

    private ErrorReporter() {
    }

    public static ErrorReporter getInstance() {
        return ERROR_REPORTER;
    }

    public void report(Exception ex) {
        LOG.error("Error occurred. Cause: ", ex);
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
