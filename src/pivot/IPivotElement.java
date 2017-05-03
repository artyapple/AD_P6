package pivot;

import element.IElement;

public interface IPivotElement {
	
	public <T> long getPivot(int startIndex, int endIndex, IElement<T>[] a);
	
	public String getName();

}
