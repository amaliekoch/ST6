public class QuestionnaireModel {
    //ATTRIBUTTER:
    public String numberIEday;
    public String numberUrinationDay;
    public String numberNocturiaDay;
    public String numberUrgeDay;
    public String bladderCapacity;
    public String detrusorOveractivity;
    public String qolScale;

    //CONSTRUCTOR
    public QuestionnaireModel(String numberIEday, String numberUrinationDay, String numberNocturiaDay, String numberUrgeDay, String bladderCapacity, String detrusorOveractivity, String qolScale) {
        this.numberIEday = numberIEday;
        this.numberUrinationDay = numberUrinationDay;
        this.numberNocturiaDay = numberNocturiaDay; 
        this.numberUrgeDay = numberUrgeDay; 
        this.bladderCapacity = bladderCapacity;
        this.detrusorOveractivity = detrusorOveractivity;
        this.qolScale = qolScale;
    }

    //GETTERS
    public String getNumberIEday() {
        return numberIEday;
    }

    public String getNumberUrinationDay() {
        return numberUrinationDay;

    }
  
    public String getNumberNocturiaDay() {
        return numberNocturiaDay;
    }

    public String getNumberUrgeDay() {
        return numberUrgeDay;
    }

    public String getBladderCapacity() {
        return bladderCapacity;
    }

    public String getDetrusorOveractivity() {
        return detrusorOveractivity;
    }

    public String getQolscale() {
        return qolScale;
    }


}