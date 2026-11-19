package fileCreatorsAlsheikhAhmad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends ReaderProductAlsheikhAhmad {
	BufferedReader ein;
	
	public ConcreteProductB() throws IOException {
		ein = new BufferedReader(new FileReader("Sportverein.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String a[] = new String [5];
		for (int i = 0; i < a.length; i++) {
			a[i] = ein.readLine();
		}
		return a;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	
	}
}
