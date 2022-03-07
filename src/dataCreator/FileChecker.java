package dataCreator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileChecker {
    
    private String username;
    private String password;

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private Scanner scanner;

    public FileChecker(String username, String password) {
        this.username = username;
        this.password = password;
        

        try{

            this.fileReader = new FileReader(FILE_CONSTANTS.FILE_PATH);
            this.bufferedReader = new BufferedReader(this.fileReader);


        }catch(FileNotFoundException error){
            System.out.println("File Not found");
            
        }
    }

    public boolean userFound(){
        String line;
        boolean isFound = false;

        try {
            while(bufferedReader.ready()){

                line = bufferedReader.readLine();
                if(line.equals(username + " " + password)){
                    isFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("We hit an error");
        }

        return isFound;

    }

    public boolean userFoundScanner(){
        
        try {
            scanner = new Scanner(FILE_CONSTANTS.FILE_PATH);
        } catch (FileNotFoundException e) {
           System.out.println("File not found");
        }

        boolean isFound = false;
        while(scanner.hasNextLine()){

            if(username.equals(scanner.next().toString()) && password.equals(scanner.next().toString()) ){
                isFound = true;
                break;
            }
        }
        return isFound;
    }

}
