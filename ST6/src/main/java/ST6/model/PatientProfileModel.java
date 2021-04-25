package ST6.model;
import ST6.handler.*;
import ST6.database.DatabaseManipulator;

public class PatientProfileModel {

    private String cprNumber;
    private String name;
    private String gender; 
    private int age; 

    //private String CPR;
    //private static String cpr;

    public PatientProfileModel(String cprNumber, String name, String gender, int age) {
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
   
    public int getAge() {
        return age;
    }

    public static void getPatientProfiledata(String cprNumber){              // Opretter handler og henter data
        PatientProfileHandler ph = new PatientProfileHandler();             
        DatabaseManipulator.executeQueryWithResultSet(ph);
    }

}
