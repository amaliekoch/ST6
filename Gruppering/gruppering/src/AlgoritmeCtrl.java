public class AlgoritmeCtrl {
    
    public String group;
    public String age;

    // Attributter fra questionnaire
    public String numberIEday;
    public String numberUrinationDay;
    public String numberNocturiaDay;
 

    public void getGroup(){ 
        if (Integer.parseInt(age) > 64){ // Her tjekkes alder som en int i stedet for en String.
            group = "gammel"; // Denne linje er sådan set en setter, der er inde i getteren.
            groupOld();
        }
            else {
                group = "ung";
                groupYoung();
            }
    }

    public String groupOld(){
        if (Integer.parseInt(numberUrinationDay) < 9 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) ==0 ){
            group = "Urge";
        }
        else if (Integer.parseInt(numberUrinationDay) < 9 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) >0 ){
            group = "UrgeIE";
        }
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >1 && Integer.parseInt(numberIEday) ==0 ){
            group = "FreqUrge";
        }
        else if (Integer.parseInt(numberUrinationDay) > 8 || Integer.parseInt(numberNocturiaDay) >1 && Integer.parseInt(numberIEday) >0 ){
            group = "FreqUrgeIE";
        }
        return group;
    }

    public String groupYoung(){
        if (Integer.parseInt(numberUrinationDay) < 8 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) ==0 ){
            group = "Urge";
        }
        else if (Integer.parseInt(numberUrinationDay) < 8 && Integer.parseInt(numberNocturiaDay) == 0 && Integer.parseInt(numberIEday) >0 ){
            group = "UrgeIE";
        }
        else if (Integer.parseInt(numberUrinationDay) > 7 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) ==0 ){
            group = "FreqUrge";
        }
        else if (Integer.parseInt(numberUrinationDay) > 7 || Integer.parseInt(numberNocturiaDay) >0 && Integer.parseInt(numberIEday) >0 ){
            group = "FreqUrgeIE";
        }
        return group;    
        
    }
}
