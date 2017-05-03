package datagen;

import element.IElement;

public interface DataGenerator {

	@SuppressWarnings("rawtypes")
	public IElement[] getArrayWithData(int size);
	
}
