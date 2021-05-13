package ST6.controller;
import ST6.App;
import ST6.handler.*;
import ST6.model.*;
import ST6.controller.*;

public abstract class Algorithm {

    public String ageGroup;
    public String patientGroup;

    public double effectivenessScore1 = 0.0; // variabel der skal indeholde effectiveness score for treatment 1
    public double effectivenessScore2 = 0.0; // variabel der skal indeholde effectiveness score for treatment 2
    public double effectivenessScore3 = 0.0; // variabel der skal indeholde effectiveness score for treatment 3

    public String paradigm1; 
    public String electrodeType1;
    public String info1; 
    public String duration1; 

    public String paradigm2; 
    public String electrodeType2;
    public String info2; 
    public String duration2; 

    public String paradigm3; 
    public String electrodeType3;
    public String info3; 
    public String duration3; 

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
            //recommended treatment 1 - Urge S
             paradigm1 = "Urge stimulation - 60 seconds";
             duration1 = "60 seconds";
             electrodeType1 = "Surface electrode"; 
             effectivenessScore1 = 57.89;
             info1 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a surface electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient.";            
            
            //recommended treatment 2 - Urge P 
            paradigm2 = "Urge stimulation - 60 seconds";
            duration2 = "60 seconds";
            electrodeType2 = "percutaneous electrode"; 
            effectivenessScore2 = 52.67;
            info2 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a percutaneous electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient. Additionally a surface electrode could be used as a start to try out the neurostimulation treatment";

            //recommended treatment 3 - Time 4 P 
            paradigm3 = "Time limited stimulation - 4 hours";
            duration3 = "4 hours";
            electrodeType3 = "percutaneous electrode"; 
            effectivenessScore3 = 44.67;
            info3 = "Time limited stimulation, with a duration of 4 hours min per stimulation and with a percutaneous electrode. It is recommended to stimulate in the morning when waking up and in the night before going to bed. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation.";
        }
        else if (patientGroup == "UrgeIE"){ // hvis patienten er grupperet som "UrgeIE"
             //recommended treatment 1 - constant S
             paradigm1 = "Constant stimulation - 24 hours";
             duration1 = "24 hours";
             electrodeType1 = "Surface electrode"; 
             effectivenessScore1 = 52.71;
             info1 = "Constant stimulation with a surface electrode. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation. The percutaneous electrode could be considered if the stimulation proves effective and will be used permanently."; 
            
            //recommended treatment 2 - urge P
             paradigm2 = "Urge stimulation - 60 seconds";
             duration2 = "60 seconds";
             electrodeType2 = "Percutaneous electrode"; 
             effectivenessScore2 = 51.00;
             info2 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a percutaneous electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient. Additionally a surface electrode could be used as a start to try out the neurostimulation treatment"; 

            //recommended treatment 3 - Urge S
             paradigm3 = "Urge stimulation - 60 seconds";
             duration3 = "60 seconds";
             electrodeType3 = "Surface electrode"; 
             effectivenessScore3 = 44.00;
             info3 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a surface electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient.";
        }
        else if (patientGroup == "FreqUrge"){ // hvis patienten er grupperet som FreqUrge
             //recommended treatment 1 - time limited 30 P
             paradigm1 = "Time limited stimulation - 30 minutes";
             duration1 = "30 minutes";
             electrodeType1 = "Percutaneous electrode";
             effectivenessScore1 = 62.67; 
             info1 = "Time limited stimulation, with a duration of 30 min per stimulation and with a percutaneous electrode. A surface electrode could be used as a start to try out the neurostimulation treatment."; 
            
            //recommended treatment 2 - time limited 4 S
             paradigm2 = "Time limited stimulation - 4 hours";
             duration2 = "4 hours";
             electrodeType2 = "Surface electrode"; 
             effectivenessScore2 = 61.00;
             info2 = "Time limited stimulation, with a duration of 4 hours min per stimulation and with a surface electrode. It is recommended to stimulate in the morning when waking up and in the night before going to bed. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation."; 

            //recommended treatment 3 - Constant P 
             paradigm3 = "Constant stimulation - 24 hours";
             duration3 = "24 hours";
             electrodeType3 = "Percutaneous electrode"; 
             effectivenessScore3 = 55.80;
             info3 = "Time limited stimulation with a percutaneous electrode. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation. A surface electrode could be used as a start to try out the neurostimulation treatment.";

        }
        else if (patientGroup == "FreqUrgeIE"){ // hvis patienten er grupperet som "FreqUrgeIE"
             //recommended treatment 1 - Urge P 
             paradigm1 = "Urge stimulation - 60 seconds";
             duration1 = "60 seconds";
             electrodeType1 = "Percutaneous electrode";
             effectivenessScore1 = 50.73; 
             info1 = "Urge stimulation, with a duration of 60 seconds per stimulation and with a percutaneous electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient. Additionally a surface electrode could be used as a start to try out the neurostimulation treatment"; 
            
            //recommended treatment 2 - time limited 15 P 
             paradigm2 = "Time limited stimulation - 15 minutes";
             duration2 = "15 minutes";
             electrodeType2 = "Percutaneous electrode"; 
             effectivenessScore2 = 48.00;
             info2 = "Time limited stimulation, with a duration of 15 min per stimulation and with a percutaneous electrode. A surface electrode could be used as a start to try out the neurostimulation treatment."; 

            //recommended treatment 3 - constant P
             paradigm3 = "Constant stimulation - 24 hours";
             duration3 = "24 hours";
             electrodeType3 = "Percutaneous electrode"; 
             effectivenessScore3 = 47.17;
             info3 = "Time limited stimulation with a percutaneous electrode. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation. A surface electrode could be used as a start to try out the neurostimulation treatment.";
        }
    }
}

// skabeloner for recommended treatments: 
// Urge - surface: 
// Urge - percutaneous: 
// Time-limited - 15 min - Surface: 
// Time-limited - 15 min - percutaneous:
// Time-limited - 30 min - Surface: 
// Time-limited - 30 min - percutaneous:
// Time-limited - 4 hours - Surface: 
// Time-limited - 4 hours - percutaneous:
// Constant - surface: 
// Constant - percutaneous: 

/*Urge - surface:
paradigm = "Urge stimulation";
electrodeType = "Surface electrode"; 
effectivenessScore = 0.0;
info = "Urge stimulation, with a duration of 60 seconds per stimulation and with a surface electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient.";
*/

/*Urge - percutaneous:
paradigm = "Urge stimulation";
electrodeType = "percutaneous electrode"; 
effectivenessScore = 0.0;
info = "Urge stimulation, with a duration of 60 seconds per stimulation and with a percutaneous electrode. Because of the short stimulation period, the intensity can be set higher compared to continuous stimulation - remember that it shall still be tolerable for the patient. Additionally a surface electrode could be used as a start to try out the neurostimulation treatment";
*/

/*Time limited 15 - surface:
paradigm = "Time limited stimulation - 15 min";
electrodeType = "Surface electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 15 min per stimulation and with a surface electrode. The percutaneous electrode could be considered if the stimulation proves effective and will be used permanently.";
*/

/*Time limited 15 - percutaneous:
paradigm = "Time limited stimulation - 15 min";
electrodeType = "percutaneous electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 15 min per stimulation and with a percutaneous electrode. A surface electrode could be used as a start to try out the neurostimulation treatment.";
*/

/*Time limited 30 - surface:
paradigm = "Time limited stimulation - 30 min";
electrodeType = "Surface electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 30 min per stimulation and with a surface electrode. The percutaneous electrode could be considered if the stimulation proves effective and will be used permanently.";
*/

/*Time limited 30 - percutaneous:
paradigm = "Time limited stimulation - 30 min";
electrodeType = "percutaneous electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 15 min per stimulation and with a percutaneous electrode. A surface electrode could be used as a start to try out the neurostimulation treatment.";
*/

/*Time limited 4 - surface:
paradigm = "Time limited stimulation - 4 hours";
electrodeType = "Surface electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 4 hours min per stimulation and with a surface electrode. It is recommended to stimulate in the morning when waking up and in the night before going to bed. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation.";
*/

/*Time limited 4 - percutaneous:
paradigm = "Time limited stimulation - 4 hours";
electrodeType = "percutaneous electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation, with a duration of 4 hours min per stimulation and with a percutaneous electrode. It is recommended to stimulate in the morning when waking up and in the night before going to bed. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation.";
*/

/*Constant 24 - surface:
paradigm = "Constant stimulation - 24 hours";
electrodeType = "Surface electrode"; 
effectivenessScore = 0.0;
info = "Constant stimulation with a surface electrode. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation. The percutaneous electrode could be considered if the stimulation proves effective and will be used permanently.";
*/

/*Constant 24 - percutaneous:
paradigm = "Constant stimulation - 24 hours"";
electrodeType = "percutaneous electrode"; 
effectivenessScore = 0.0;
info = "Time limited stimulation with a percutaneous electrode. The intensity should not reach the tolerable pain level because of the duration of the stimulation. A low intensity will reduce the risk of adverse events such as neural habituation. A surface electrode could be used as a start to try out the neurostimulation treatment.";
*/