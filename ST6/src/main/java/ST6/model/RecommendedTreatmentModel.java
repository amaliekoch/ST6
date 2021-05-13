package ST6.model;

public class RecommendedTreatmentModel {
    //ATTRIBUTTER
    private String paradigm;
    private String duration;
    private String electrode; 
    private String intensity;

    // CONSTRUCTOR 
    public RecommendedTreatmentModel(String paradigm, String duration, String electrode, String intensity) {
        this.paradigm = paradigm;
        this.duration = duration;
        this.electrode = electrode; 
        this.intensity = intensity; 
    }

     // GETTER & SETTER TIL PARADIGM
     public String getParadigm() {
        return paradigm;
    }

    public void setParadigm(String stimulationParadigm) {
        paradigm = stimulationParadigm;
    }

    // GETTER & SETTER TIL DURATION
    public String getDuration() { 
        return duration;
    }

    public void setDuration(String stimulationDuration) {
        duration = stimulationDuration;
    }

    // GETTER & SETTER TIL ELECTRODE
    public String getElectrode() {
        return electrode;
    }

    public void setElectrode(String stimulationElectrode) {
        electrode = stimulationElectrode;
    }
   
    // GETTER & SETTER TIL INTENSITY 
    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String stimulationIntensity){
        intensity = stimulationIntensity;
    }
}
