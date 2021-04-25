package main.java.ST6.handler;
import java.sql.ResultSet;
import java.sql.SQLException;
import ST6.database.*;
import ST6.model.*;
import ST6.model.PatientProfileModel;

public class PatientProfileHandler implements Queryable {

    public  static String tempName = "fejl"; // bruges til at tjekke om der reelt er hentet et navn. Ellers skrives nemlig Fejl.
    public  static String newCPR;
    public  static String newGender;
    public  static int newAge; 
  
    
    // overskriver kommandoen i interfacet. Denne metode bliver kun kaldt hvis returnSqlQuery kommandoen går igennem
    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
            PatientProfileModel aktuelPatient = new PatientProfileModel(rs.getString("cprNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("age"));
             newCPR = aktuelPatient.getCPR();
             tempName = aktuelPatient.getName(); 
             newGender = aktuelPatient.getGender();
             newAge = aktuelPatient.getAge();
        }
    }

    // kommandoen til SQL databasen
    @Override
    public String returnSqlQuery() {
        String sqlStatement = "SELECT * FROM `PatientProfile` WHERE `cprNumber` = 1002199902";
       // String sqlStatement = "SELECT * FROM `PatientProfile` WHERE `cprNumber` =" + PatientProfileModel.getcprNumber();
        return sqlStatement;
    }
}
