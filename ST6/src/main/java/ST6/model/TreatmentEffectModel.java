package ST6.model;

public class TreatmentEffectModel {

     //ATTRIBUTTER:
     private String numberIEdayAfter;
     private String numberUrinationDayAfter;
     private String numberNocturiaDayAfter;
     private String numberUrgeDayAfter;
     private String bladderCapacityAfter;
     private String detrusorOveractivityAfter;
     private String qolScaleAfter;
     private String painAfter; 
     private String skinIrritationAfter; 
     private String worseningSymptomsAfter; 
     private String adverseEventsScaleAfter; 
     private String otherAdverseEventsAfter; 
 
     //CONSTRUCTOR
     public TreatmentEffectModel(String numberIEdayAfter, String numberUrinationDayAfter, String numberNocturiaDayAfter, String numberUrgeDayAfter, String bladderCapacityAfter, String detrusorOveractivityAfter, String qolScaleAfter, String painAfter, String skinIrritationAfter, String worseningSymptomsAfter, String adverseEventsScaleAfter, String otherAdverseEventsAfter) {
         this.numberIEdayAfter = numberIEdayAfter;
         this.numberUrinationDayAfter = numberUrinationDayAfter;
         this.numberNocturiaDayAfter = numberNocturiaDayAfter; 
         this.numberUrgeDayAfter = numberUrgeDayAfter; 
         this.bladderCapacityAfter = bladderCapacityAfter;
         this.detrusorOveractivityAfter = detrusorOveractivityAfter;
         this.qolScaleAfter = qolScaleAfter;
         this.painAfter = painAfter; 
         this.skinIrritationAfter = skinIrritationAfter; 
         this.worseningSymptomsAfter = worseningSymptomsAfter; 
         this.adverseEventsScaleAfter = adverseEventsScaleAfter; 
         this.otherAdverseEventsAfter = otherAdverseEventsAfter; 
     }
 
     //GETTERS
     public String getNumberIEdayAfter() {
         return numberIEdayAfter;
     }
 
     public String getNumberUrinationDayAfter() {
         return numberUrinationDayAfter;
     }
   
     public String getNumberNocturiaDayAfter() {
         return numberNocturiaDayAfter;
     }
 
     public String getNumberUrgeDayAfter() {
         return numberUrgeDayAfter;
     }
 
     public String getBladderCapacityAfter() {
         return bladderCapacityAfter;
     }
 
     public String getDetrusorOveractivityAfter() {
         return detrusorOveractivityAfter;
     }
 
     public String getQolscaleAfter() {
         return qolScaleAfter;
     }

     public String getPainAfter() {
        return painAfter;
    }

    public String getSkinIrritationAfter() {
        return skinIrritationAfter;
    }
    
    public String getWorseningSymptomsAfter() {
        return worseningSymptomsAfter;
    }

    public String getAdverseEventsScaleAfter() {
        return adverseEventsScaleAfter;
    }

    public String getOtherAdverseEventsAfter() {
        return otherAdverseEventsAfter;
    }
}
