package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tables {

    private ArrayList<String> tableNames = null;
    private ArrayList<String> columnData = null;

    private Map<String, String> tables;

    public void init() {
        tables = new HashMap<>();
        createTableData();
    }

    private void createTableData() {

        for (Map.Entry<String, String> allTables : getTableSchema().entrySet()) {
            tables.put(allTables.getKey(), allTables.getValue());
        }

        // for (int i = 0; i < tableNames.size(); i++) {
        // tables.put(tableNames.get(i), columnData.get(i));
        // }

    }

    public Map<String, String> getTables() {
        return tables;
    }

    private Map<String, String> getTableSchema() {
        Map<String, String> tableSchema = new HashMap<>();

        tableSchema.put("Accounts", "(account_usernames VARCHAR(255) not NULL, " + "account_password VARCHAR(255) not NULL)");
        return tableSchema;
    }

}
