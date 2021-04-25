package main.java.ST6.model;
public class SpecialistModel {
    
    //ATTRIBUTTER:
    private String username;
    private String password;

    //CONSTRUCTOR
    public SpecialistModel(String username, String password) {
        this.username = username;
        this.password = password; 
    }
  
    //GETTERS
    public String getUsername() {
        return username;
    }

     public String getPassword() {
        return password;
    }
}
