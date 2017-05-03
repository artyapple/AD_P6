package pivot;

import element.IElement;

public class PivotFirst implements IPivotElement {
	
	private final String NAME = "First element";

	@Override
	public <T> long getPivot(int startIndex, int endIndex, IElement<T>[] a) {
		return a[startIndex].getKey();
	}

	@Override
	public String getName() {
		return NAME;
	}

}
