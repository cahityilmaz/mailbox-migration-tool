package com.capp.mailbox.migration.tool;

/**
 * @author mucahit.yilmaz
 */
public final class MigrationDto {

    private String sourceHost;
    private String sourcePort;
    private String sourceUser;
    private String sourceAdmin;
    private String sourcePassword;
    private String tlsForSource;

    private String targetHost;
    private String targetPort;
    private String targetUser;
    private String targetAdmin;
    private String targetPassword;
    private String tlsForTarget;

    private boolean isTest;
    private boolean isFastMigration;

    public MigrationDto() {
    }

    public String getSourceHost() {
        return sourceHost;
    }

    public MigrationDto setSourceHost(String sourceHost) {
        this.sourceHost = sourceHost;
        return this;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public MigrationDto setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
        return this;
    }

    public String getSourceUser() {
        return sourceUser;
    }

    public MigrationDto setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
        return this;
    }

    public String getSourcePassword() {
        return sourcePassword;
    }

    public MigrationDto setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
        return this;
    }

    public String getTlsForSource() {
        return tlsForSource;
    }

    public MigrationDto setTlsForSource(String tlsForSource) {
        this.tlsForSource = tlsForSource;
        return this;
    }

    public String getTargetHost() {
        return targetHost;
    }

    public MigrationDto setTargetHost(String targetHost) {
        this.targetHost = targetHost;
        return this;
    }

    public String getTargetPort() {
        return targetPort;
    }

    public MigrationDto setTargetPort(String targetPort) {
        this.targetPort = targetPort;
        return this;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public MigrationDto setTargetUser(String targetUser) {
        this.targetUser = targetUser;
        return this;
    }

    public String getTargetPassword() {
        return targetPassword;
    }

    public MigrationDto setTargetPassword(String targetPassword) {
        this.targetPassword = targetPassword;
        return this;
    }

    public String getTlsForTarget() {
        return tlsForTarget;
    }

    public MigrationDto setTlsForTarget(String tlsForTarget) {
        this.tlsForTarget = tlsForTarget;
        return this;
    }

    public String getSourceAdmin() {
        return sourceAdmin;
    }

    public MigrationDto setSourceAdmin(String sourceAdmin) {
        this.sourceAdmin = sourceAdmin;
        return this;
    }

    public String getTargetAdmin() {
        return targetAdmin;
    }

    public MigrationDto setTargetAdmin(String targetAdmin) {
        this.targetAdmin = targetAdmin;
        return this;
    }

    public boolean isTest() {
        return isTest;
    }

    public MigrationDto setTest(boolean test) {
        isTest = test;
        return this;
    }

    public boolean isFastMigration() {
        return isFastMigration;
    }

    public MigrationDto setFastMigration(boolean fastMigration) {
        isFastMigration = fastMigration;
        return this;
    }
}
