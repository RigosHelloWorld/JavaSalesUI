package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tables {

    private  ArrayList<String> tableNames = null;
    private  ArrayList<String> columnData = null;

    private Map<String, String> tables;

   
    public void init(){
        tables = new HashMap<>();
        setTableNames();
        setColumnData();
        createTableData();
    }


    private void createTableData() {

        int i = 0;
        for (String table : tableNames) {
            tables.put(tableNames.get(i), columnData.get(i));
            i++;
        }

    }

    public Map<String, String> getTables() {
        return tables;
    }

    private void setTableNames() {
        tableNames = new ArrayList<>();
        tableNames.add("Users");
    }

    private void setColumnData() {
        columnData = new ArrayList<>();
        columnData.add("(user VARCHAR(255) not NULL, " + "password VARCHAR(12) not NULL)");
    }
}
