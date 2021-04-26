package ST6.model;
import main.java.ST6.handler.*;
//import ST6.handler.PatientProfileHandler;
import ST6.database.DatabaseManipulator;

public class PatientProfileModel {

    private String cprNumber;
    private String name;
    private String gender; 
    private String age; 

    private static String cpr;

    public PatientProfileModel(String cprNumber, String name, String gender, String age) {
        this.cprNumber = cprNumber;
        this.name = name;
        this.gender = gender; 
        this.age = age; 
    }
  
    public String getName() {
        return name;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public String getGender() {
        return gender;
    }
   
    public String getAge() {
        return age;
    }

    public static void setCprNumber(String cprNumber){
        cpr = cprNumber;
    }

    public static void getPatientProfiledata(String cprNumber){              // Opretter "handler" og henter data
        main.java.ST6.handler.PatientProfileHandler ph = new main.java.ST6.handler.PatientProfileHandler();             
        DatabaseManipulator.executeQueryWithResultSet(ph);
    }

}
