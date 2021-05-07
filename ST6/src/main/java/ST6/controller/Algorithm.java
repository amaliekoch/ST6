package ST6.controller;
import ST6.App;
import ST6.handler.*;
import ST6.model.*;
import ST6.controller.*;

public abstract class Algorithm {

    public String ageGroup;
    public String patientGroup;

    public String getAgeGroup(String age){ 
        if (Integer.parseInt(age) > 64){ // Her tjekkes alder som en int i stedet for en String.
            ageGroup = "old"; // Denne linje er sådan set en setter, der er inde i getteren.
            return ageGroup; 
            }
        else {
            ageGroup = "young";
            return ageGroup; 
        }
    }
    /* Input til questionnaire
    private String numberIEday;
    private String numberUrinationDay;
    private String numberNocturiaDay;
    private String numberUrgeDay; <-- bliver ikke brugt i grupperingen 
    private String bladderCapacity; <-- bliver ikke brugt i grupperingen 
    private String detrusorOveractivity; <-- bliver ikke brugt i grupperingen 
    private String qolScale; <-- bliver ikke brugt i grupperingen 
    */

    public String getPatientGroupOld(String numberIEday, String numberUrinationDay, String numberNocturiaDay){
        if (Integer.parseInt(numberUrinationDay) < 9 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) ==0 ){
            patientGroup = "Urge";
        }
        else if (Integer.parseInt(numberUrinationDay) < 9 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) >0 ){
            patientGroup = "UrgIE";
        }
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >1 && Integer.parseInt(numberIEday) ==0 ){
            patientGroup = "FreqUrge";
        }
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >1 && Integer.parseInt(numberIEday) >0 ){
            patientGroup = "FreqUrgeIE";
        }
        return patientGroup;
    }

    public String getPatientGroupYoung(String numberIEday, String numberUrinationDay, String numberNocturiaDay){
        if (Integer.parseInt(numberUrinationDay) < 8 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) ==0 ){
            patientGroup = "Urge";
        }
        else if (Integer.parseInt(numberUrinationDay) < 8 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) >0 ){
            patientGroup = "UrgeIE";
        }
        else if (Integer.parseInt(numberUrinationDay) > 7 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) ==0 ){
            patientGroup = "FreqUrge";
        }
        else if (Integer.parseInt(numberUrinationDay) > 7 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) >0 ){
            patientGroup = "FreqUrgeIE";
        }
        return patientGroup;    
        
    }
}

