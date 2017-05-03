package sort;
import element.IElement;


public interface SortingAlgorithm {

	public <T> void sort(IElement<T>[] a);
	
	public int getCallsCounter();

	public int getSwapCounter();

	public int getCompareCounter();
	
	public void resetCounter();
}
