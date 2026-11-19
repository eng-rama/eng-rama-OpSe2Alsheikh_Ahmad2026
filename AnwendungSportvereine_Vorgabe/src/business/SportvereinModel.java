package business;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsAlsheikhAhmad.ConcreteCreatorAB;
import fileCreatorsAlsheikhAhmad.ReaderCreatorAlsheikhAhmad;
import fileCreatorsAlsheikhAhmad.ReaderProductAlsheikhAhmad;

public class SportvereinModel {
	// speichert temporaer ein Objekt vom Typ Sportverein
    private Sportverein sportverein;

	public Sportverein getSportverein() {
		return sportverein;
	}

	public void setSportverein(Sportverein sportverein) {
		this.sportverein = sportverein;
	}
    
	public void leseAusDatei(String typ) throws IOException{
      		ReaderCreatorAlsheikhAhmad creator = new ConcreteCreatorAB();
      		ReaderProductAlsheikhAhmad product = creator.factoryMethod(typ);
      		String[] zeile = product.leseAusDatei();
      			this.sportverein = new Sportverein(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_"));
      				product.schliesseDatei();
		
	}
		
	public void schreibeSportvereineInCsvDatei() throws IOException{
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("SportvereineAusgabe.csv", true));
			aus.write(sportverein.gibSportvereinZurueck(';'));
			aus.close();
	}
}
