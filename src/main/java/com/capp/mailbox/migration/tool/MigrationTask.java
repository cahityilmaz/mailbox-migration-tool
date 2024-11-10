package com.capp.mailbox.migration.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import static com.capp.mailbox.migration.tool.Constants.HOME_FOLDER_PATH;

/**
 * @author mucahit.yilmaz
 */
public final class MigrationTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(MigrationTask.class);
    private final String taskName;
    private final UUID taskId;
    private TaskStatus taskStatus;

    private final MigrationDto migrationDto;

    public MigrationTask(MigrationDto migrationDto) {
        this.migrationDto = migrationDto;
        taskName = String.format("Migration task for %s -> %s",
                migrationDto.getSourceUser(), migrationDto.getTargetUser());
        taskId = UUID.randomUUID();
        taskStatus = TaskStatus.QUEUED;

        Thread.currentThread().setName(taskName);
    }

    public String getTaskName() {
        return taskName;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public void run() {
        String[] command = Util.createImapSyncCommand(migrationDto);
        ProcessBuilder pBuilder = new ProcessBuilder(command).directory(new File(HOME_FOLDER_PATH)).inheritIO();
        try {
            Process proc = pBuilder.start();
            LOG.info("Migration task started for: {} -> {}", migrationDto.getSourceUser(), migrationDto.getTargetUser());

            taskStatus = TaskStatus.RUNNING;
            TaskNotificationManager.getInstance().fireTaskUpdated(this);

            proc.waitFor();
        } catch (IOException ex) {
            ErrorReporter.getInstance().report(ex);
        } catch (InterruptedException e) {
            LOG.error("An error occurred:", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MigrationTask other = (MigrationTask) o;
        return Objects.equals(taskId, other.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(taskId);
    }
}
