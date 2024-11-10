package com.capp.mailbox.migration.tool;

public enum TaskStatus {
    QUEUED("Queued"),
    RUNNING("Running"),
    FINISHED("Finished");

    private final String text;

    TaskStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
