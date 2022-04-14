package server;

import java.util.HashMap;
import java.util.Map;

public class Tables {

    private Map<String, String> tables;
    Map<String, String> tableSchema = null;

    public void init() {
        tables = new HashMap<>();
        createTableData();
    }

    private void createTableData() {
        setTableSchema();

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
    
        return tableSchema;
    }

    private void setTableSchema(){
        tableSchema = new HashMap<>();

        tableSchema.put("Accounts", "(account_usernames VARCHAR(255) not NULL, " + "account_password VARCHAR(255) not NULL)");
        
        tableSchema.put("Inventory", "(slab_num INT NOT NULL," +  "width DOUBLE NOT NULL," + "length INT NOT NULL, mfg_part_num VARCHAR(100) NOT NULL)" );
    }

}
