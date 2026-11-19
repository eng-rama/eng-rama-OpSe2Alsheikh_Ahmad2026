package fileCreatorsAlsheikhAhmad;

import java.io.IOException;

public class ConcreteCreatorAB extends ReaderCreatorAlsheikhAhmad {

	@Override
	public ReaderProductAlsheikhAhmad factoryMethod(String typ) throws IOException {
		if("csv".equals(typ)){
			return new ConcreteProductA();
		}else {
			return new ConcreteProductB();
		}
	}

}
