package pivot;

import element.IElement;

public class PivotMedian implements IPivotElement{

	private final int THREE_MEDIAN = 3;
	private final String NAME = "3 Median";
	
	@Override
	public <T> long getPivot(int startIndex, int endIndex, IElement<T>[] a) {
		long pivot = 0;
		int med[] = new int[]{startIndex, endIndex, (endIndex+startIndex)/2};
		for(int ind : med){
			pivot = pivot + a[ind].getKey(); 
		}
		return (pivot/THREE_MEDIAN);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
