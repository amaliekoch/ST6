public class App {
    public static void main(String[] args) throws Exception {
    
    // Opretter instanser af patientmodellen
    PatientProfileModel ny = new PatientProfileModel("1111", "Jens Hansen", "Male", "60"); 
  //  PatientProfileModel gammel = new PatientProfileModel("2222", "Jane Doe", "Female", "65");

    // Tilføjer et spørgeskema til en patient af typen Questionnaire-model. De ligger i et array.
    ny.addQuestionnaire("3", "10", "0", "15", "300-400", "unknown", "6");

   // System.out.println(ny.getGroup()); //Dette kalder metoden getGroup, hvor den beregnes.
   // System.out.println(gammel.getGroup());
    // System.out.println(ny.patientQuestionnaire.getNumberIEday());

   // System.out.println(patientQuestionnaire.getNumberIEday());

}
   
}

