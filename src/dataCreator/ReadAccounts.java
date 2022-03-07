package dataCreator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadAccounts {

    private Map<String, String> accounts;
    private Scanner scanner;

    public ReadAccounts() {
        accounts = new HashMap<>();
        readAccounts();

    }

    private void readAccounts() {
     

        try {
            scanner = new Scanner(FILE_CONSTANTS.FILE_PATH);
            String line = "";
            String splitBy = ",";

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
              
                String[] account = line.split(splitBy);
                


                accounts.put(account[0], account[1]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


    public Map<String,String> getAccount(){
        return accounts;
    }
}
