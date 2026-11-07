package gui;


import business.Sportverein;
import business.SportvereinModel;
import javafx.stage.Stage;

public class SportvereinControl {
	SportvereinModel sportvereinModel = new SportvereinModel();
	private SportvereinView sportvereinView;
	
	
	public SportvereinControl(Stage primaryStage) {
		this.sportvereinView = new SportvereinView(primaryStage, this, sportvereinModel);
	}

	public void nehmeSportvereinAuf(String name, String ort, int anzahlMitglieder,
	       	int anzahlEhemaligerMitglieder, String[] sportarten){
    	try{ 
    		sportvereinModel.setSportverein(new Sportverein(name, ort, anzahlMitglieder, anzahlEhemaligerMitglieder, sportarten));
    		sportvereinView.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		sportvereinView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    public void zeigeSportvereineAn(){
    	if(sportvereinModel.getSportverein() != null){
    		sportvereinView.zeigeTextAn(sportvereinModel.getSportverein().gibSportvereinZurueck(' '));
    	}
    	else{
    		sportvereinView.zeigeInformationsfensterAn("Bisher wurde keine Sportverein aufgenommen!");
    	}
    }    
		  
    public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			sportvereinModel.leseAusDatei(typ);
      			sportvereinView.zeigeInformationsfensterAn(
      	  	   			"Der Sportverein wurde gelesen!");
      		}
       		else{
       			sportvereinView.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(Exception exc){
			sportvereinView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeSportvereineInCsvDatei() {
		try {
			sportvereinModel.schreibeSportvereineInCsvDatei();
			sportvereinView.zeigeInformationsfensterAn(
	   			"Die Sportvereine wurden gespeichert!");
		}	
		
		catch(Exception exc){
			sportvereinView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

	
}
