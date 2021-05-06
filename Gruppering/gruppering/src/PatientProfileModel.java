public class PatientProfileModel {

    private String cprNumber;
    private String name;
    private String gender; 
    private String age; 
    private String group;

    QuestionnaireModel[] patientQuestionnaire = new QuestionnaireModel[10]; 

    // CONSTRUCTOR 
    public PatientProfileModel(String cprNumber, String name, String gender, String age) {
        this.cprNumber = cprNumber;
        this.name = name;
        this.gender = gender; 
        this.age = age; 

    }

    public String getName() {
        return name;
    }
    
    public String getAge() {
        return age;
    }

    public String getCpr() {
        return cprNumber;
    }

    public String getGender() {
        return gender;
    }
    
    public String getGroup(){ 
        if (Integer.parseInt(age) > 64){ // Her tjekkes alder som en int i stedet for en String.
            this.group = "gammel"; // Denne linje er sådan set en setter, der er inde i getteren.
            }
            else {
                this.group = "ung";
            }
        return group;
    }

    public void addQuestionnaire(String numberIEday, String numberUrinationDay, String numberNocturiaDay, 
    String numberUrgeDay, String bladderCapacity, String detrusorOveractivity, String qolScale){

        QuestionnaireModel quest = new QuestionnaireModel(numberIEday, numberUrinationDay, numberNocturiaDay, numberUrgeDay, 
        bladderCapacity, detrusorOveractivity, qolScale);


            for (int i =0; i < this.patientQuestionnaire.length; i++){
                if (patientQuestionnaire[i] == null){
                    patientQuestionnaire[i] = quest;    
                }
            }
        
    }
}

