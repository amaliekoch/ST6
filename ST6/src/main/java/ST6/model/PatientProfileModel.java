package ST6.model;
import ST6.handler.*;
//import ST6.handler.PatientProfileHandler;
import ST6.database.DatabaseManipulator;

public class PatientProfileModel {

    private String cprNumber;
    private String name;
    private String gender; 
    private String age; 
    private static String cpr;

    // CONSTRUCTOR 
    public PatientProfileModel(String cprNumber, String name, String gender, String age) {
        this.cprNumber = cprNumber;
        this.name = name;
        this.gender = gender; 
        this.age = age; 
    }
  
    // GETTER & SETTER TIL NAME 
    public String getName() {
        return name;
    }

    public void setName(String patientName) {
        name = patientName;
    }

    // GETTER & SETTER TIL CPR-nummer
    public String getCprNumber() { 
        return cprNumber;
    }

    public void setCprNumber(String cprnumber) {
        cprNumber = cprnumber;
    }

    // GETTER & SETTER TIL GENDER
    public String getGender() {
        return gender;
    }

    public void setGender(String genderEntered) {
        gender = genderEntered;
    }
   
    // GETTER & SETTER TIL AGE 
    public String getAge() {
        return age;
    }

    public void setAge(String ageEntered){
        age = ageEntered;
    }

    // GETTER & SETTER TIL AT TJEKKE CPR FRA INPUT PÅ GUI 
    public static void checkCprNumber(String cprNumber){
        cpr = cprNumber;
    }

    public static String getCprInput() {
        return cpr;
    }

    //METODE DER HENTER INFORMATION OM PATIENTEN I DATABASEN (fra tabel med patient profil data)
    public static void getPatientProfiledata(String cprNumber){              // Opretter "handler" og henter data
        PatientProfileHandler ph = new PatientProfileHandler();             
        DatabaseManipulator.executeQueryWithResultSet(ph);
    }

}
