package ST6.controller;
import ST6.App;
import ST6.handler.*;
import ST6.model.*;
import ST6.controller.*;

public abstract class Algorithm {

    public String ageGroup;
    public String patientGroup;

    public double effectivenessScore1 = 0.6; // variabel der skal indeholde effectiveness score for treatment 1
    public double effectivenessScore2 = 0.4; // variabel der skal indeholde effectiveness score for treatment 2
    public double effectivenessScore3 = 0.2; // variabel der skal indeholde effectiveness score for treatment 3

    public String paradigm1; 
    public String electrodeType1;
    public String info1; 

    public String paradigm2; 
    public String electrodeType2;
    public String info2; 

    public String paradigm3; 
    public String electrodeType3;
    public String info3; 

    public String getAgeGroup(String age){ 
        if (Integer.parseInt(age) > 64){ 
            ageGroup = "old"; 
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
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) ==0 ){
            patientGroup = "FreqUrge";
        }
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) >0 ){
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

    public void recommendedTreatments (String patientGroup){ 
        if (patientGroup == "Urge"){ // hvis patienten er grupperet som "urge"
            //recommended treatment 1
             paradigm1 = "Urge stimulation";
             electrodeType1 = "Surface electrode"; 
             effectivenessScore1 = 0.0;
             info1 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a surface electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient.";            
            
             //recommended treatment 2
             paradigm2 = "xx";
             electrodeType2 = "yy"; 
             effectivenessScore2 = 0.0;
             info2 = "zz"; 

            //recommended treatment 2
             paradigm3 = "xx";
             electrodeType3 = "yy"; 
             effectivenessScore3 = 0.0;
             info3 = "zz"; 
        }
        else if (patientGroup == "UrgeIE"){ // hvis patienten er grupperet som "UrgeIE"
             //recommended treatment 1
             paradigm1 = "xx";
             electrodeType1 = "yy"; 
             effectivenessScore1 = 0.0;
             info1 = "zz"; 
            
            //recommended treatment 2
             paradigm2 = "xx";
             electrodeType2 = "yy"; 
             effectivenessScore2 = 0.0;
             info2 = "zz"; 

            //recommended treatment 3
             paradigm3 = "xx";
             electrodeType3 = "yy"; 
             effectivenessScore3 = 0.0;
             info3 = "zz";

        }
        else if (patientGroup == "FreqUrge"){ // hvis patienten er grupperet som FreqUrge
             //recommended treatment 1
             paradigm1 = "xx";
             electrodeType1 = "yy";
             effectivenessScore1 = 0.0; 
             info1 = "zz"; 
            
            //recommended treatment 2
             paradigm2 = "xx";
             electrodeType2 = "yy"; 
             effectivenessScore2 = 0.0;
             info2 = "zz"; 

            //recommended treatment 3
             paradigm3 = "xx";
             electrodeType3 = "yy"; 
             effectivenessScore3 = 0.0;
             info3 = "zz";

        }
        else if (patientGroup == "FreqUrgeIE"){ // hvis patienten er grupperet som "FreqUrgeIE"
             //recommended treatment 1
             paradigm1 = "xx";
             electrodeType1 = "yy";
             effectivenessScore1 = 0.0; 
             info1 = "zz"; 
            
            //recommended treatment 2
             paradigm2 = "xx";
             electrodeType2 = "yy"; 
             effectivenessScore2 = 0.0;
             info2 = "zz"; 

            //recommended treatment 3
             paradigm3 = "xx";
             electrodeType3 = "yy"; 
             effectivenessScore3 = 0.0;
             info3 = "zz";
        }
    }
}

