package com.capp.mailbox.migration.tool;

record CsvModel(String sourceUser, String sourceAdmin, String sourcePassword, String targetUser, String targetAdmin,
                String targetPassword) {

    public String[] toTableRow() {
        return new String[]{sourceUser, sourceAdmin, sourcePassword, targetUser, targetAdmin, targetPassword};
    }

    public static CsvModel parse(String csv) throws Exception {
        if (csv == null || csv.isBlank()) {
            throw new Exception(csv + " could not be parsed because of it is null or empty!");
        }
        String[] variables = csv.split(";");
        if (variables.length < 6) {
            throw new Exception(csv + " could not be parsed because of the given csv text is not expected we liked!");
        }
        return new CsvModel(variables[0], variables[1], variables[2], variables[3], variables[4], variables[5]);
    }
}
