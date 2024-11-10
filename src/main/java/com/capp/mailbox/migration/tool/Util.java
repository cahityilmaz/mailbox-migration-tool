package com.capp.mailbox.migration.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.capp.mailbox.migration.tool.Constants.LOGS_FOLDER_PATH;

/**
 * @author mucahit.yilmaz
 */
final class Util {

    private static final String IMAP_SYNC_TOOL_PATH = getAppPath();

    public static String getAppPath() {
        var appName = getAppName();
        return new File("imapsync" + File.separator + appName).getAbsolutePath();
    }

    public static String getAppName() {
        var osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("windows")) {
            return "imapsync.exe";
        }
        return "imapsync";
    }

    public static String[] createImapSyncCommand(final MigrationDto migrationDto) {
        final List<String> commandList = new ArrayList<>();
        commandList.add(IMAP_SYNC_TOOL_PATH);

        addSourceInformations(commandList, migrationDto);
        addTargetInformations(commandList, migrationDto);

        if (migrationDto.isTest()) {
            commandList.add("--justfolders");
            commandList.add("--dry");
        }

        if (migrationDto.isFastMigration()) {
            commandList.add("--nofoldersizes");
            commandList.add("--nofoldersizesatend");
        }

        List<String> extraCommands = readExtraCommandFile();
        if (!extraCommands.isEmpty()) {
            commandList.addAll(extraCommands);
        }

        commandList.add("--logdir");
        commandList.add(LOGS_FOLDER_PATH);

        return commandList.toArray(String[]::new);
    }

    private static void addSourceInformations(List<String> commandList, MigrationDto arguments) {
        commandList.add("--host1");
        commandList.add(arguments.getSourceHost());
        commandList.add("--port1");
        commandList.add(arguments.getSourcePort());
        commandList.add("--user1");
        commandList.add(arguments.getSourceUser());

        if (arguments.getSourceAdmin() != null && !arguments.getSourceAdmin().trim().isBlank()) {
            commandList.add("--authuser1");
            commandList.add(arguments.getSourceAdmin());
        }

        commandList.add("--password1");
        commandList.add(arguments.getSourcePassword());
        commandList.add(arguments.getTlsForSource());
    }

    private static void addTargetInformations(List<String> commandList, MigrationDto arguments) {
        commandList.add("--host2");
        commandList.add(arguments.getTargetHost());
        commandList.add("--port2");
        commandList.add(arguments.getTargetPort());
        commandList.add("--user2");
        commandList.add(arguments.getTargetUser());

        if (arguments.getTargetAdmin() != null && !arguments.getTargetAdmin().trim().isBlank()) {
            commandList.add("--authuser2");
            commandList.add(arguments.getTargetAdmin());
        }

        commandList.add("--password2");
        commandList.add(arguments.getTargetPassword());
        commandList.add(arguments.getTlsForTarget());
    }

    private static List<String> readExtraCommandFile() {
        File extraCommandFile = new File("imapsync"+ File.separator + "extra-command.txt");
        try {
            return Files.readAllLines(extraCommandFile.toPath());
        } catch (IOException ex) {
            ErrorReporter.getInstance().report(new Exception(
                    "extra-command.txt file is not found on the path: " + extraCommandFile.toPath(), ex));
        }
        return Collections.emptyList();
    }

    public static MigrationDto convertCsvModelToMigrationDto(CsvModel model) {
        return new MigrationDto()
                .setSourceUser(model.sourceUser())
                .setSourceAdmin(model.sourceAdmin())
                .setSourcePassword(model.sourcePassword())
                .setTargetUser(model.targetUser())
                .setTargetAdmin(model.targetAdmin())
                .setTargetPassword(model.targetPassword());
    }

}
