package ST6.handler;
import java.sql.ResultSet;
import java.sql.SQLException;
import ST6.database.*;
import ST6.model.*;
import ST6.model.PatientProfileModel;

public class PatientProfileHandler implements Queryable {

    public  static String patientName = "fejl"; // bruges til at tjekke om der reelt er hentet et navn. Ellers skrives der "Fejl"
    public  static String patientCPR;
    public  static String patientGender;
    public  static String patientAge; 
    
    // overskriver kommandoen i interfacet. Denne metode bliver kun kaldt hvis returnSqlQuery kommandoen går igennem
    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
            PatientProfileModel aktuelPatient = new PatientProfileModel(rs.getString("cprNumber"), rs.getString("name"), rs.getString("gender"), rs.getString("age"));
             patientCPR = aktuelPatient.getCprNumber();
             patientName = aktuelPatient.getName(); 
             patientGender = aktuelPatient.getGender();
             patientAge = aktuelPatient.getAge();
        }
    }

    // kommandoen til SQL databasen 
    @Override
    public String returnSqlQuery() {
        String sqlStatement = "SELECT * FROM `PatientProfile` WHERE `cprNumber` = 1304081203"; // CPR er lige nu tastet manuelt. Brug nedenstående når GUI kører
       // String sqlStatement = "SELECT * FROM `PatientProfile` WHERE `cprNumber` =" + PatientProfileModel.getcprNumber();
        return sqlStatement;
    }
}
