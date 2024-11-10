package com.capp.mailbox.migration.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

final class Constants {
    public static final String HOME_FOLDER_PATH = System.getProperty("user.home") + File.separator + "migrationTool";
    public static final String LOGS_FOLDER_PATH = HOME_FOLDER_PATH + File.separator + "logs";

    static {
        File applicationRunPath = new File(HOME_FOLDER_PATH);
        File imapsyncLogFolderPath = new File(LOGS_FOLDER_PATH);
        try {
            if (!applicationRunPath.exists()) {
                Files.createDirectory(applicationRunPath.toPath());
            }
            if (!imapsyncLogFolderPath.exists()) {
                Files.createDirectory(imapsyncLogFolderPath.toPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
