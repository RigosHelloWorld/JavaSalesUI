package person;

import dataCreator.FileChecker;

public class UserAccount {
    private String username;
    private String password;
    

    public UserAccount(String userName, String password){
        this.username = userName;
        this.password = password;

    }

    public boolean isValide(){
        
        FileChecker fileChecker = new FileChecker(this.username, this.password);
        return fileChecker.userFoundScanner();
    }
 

}
