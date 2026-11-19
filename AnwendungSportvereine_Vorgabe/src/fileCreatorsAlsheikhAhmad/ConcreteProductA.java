package fileCreatorsAlsheikhAhmad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends ReaderProductAlsheikhAhmad {
	BufferedReader ein;
	
	public ConcreteProductA() throws IOException {
		ein = new BufferedReader(new FileReader("Sportverein.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {

		return ein.readLine().split(";");
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	
	}

}
