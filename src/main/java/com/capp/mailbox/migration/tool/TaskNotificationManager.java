package com.capp.mailbox.migration.tool;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class TaskNotificationManager {

    public static final String TASK_ADDED_PROPERTY = "Task.Added";
    public static final String TASK_UPDATED_PROPERTY = "Task.Updated";

    private static TaskNotificationManager INSTANCE;

    private final PropertyChangeSupport PCS = new PropertyChangeSupport(this);

    public static TaskNotificationManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskNotificationManager();
        }
        return INSTANCE;
    }

    public void addListener (PropertyChangeListener listener) {
        PCS.addPropertyChangeListener(listener);
    }

    public void removeListener (PropertyChangeListener listener) {
        PCS.removePropertyChangeListener(listener);
    }

    public synchronized void fireTaskAdded(MigrationTask task) {
        PCS.firePropertyChange(TASK_ADDED_PROPERTY, null, task);
    }

    public synchronized void fireTaskUpdated(MigrationTask task) {
        PCS.firePropertyChange(TASK_UPDATED_PROPERTY, null, task);
    }

}
