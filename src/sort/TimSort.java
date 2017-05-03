package sort;

import counter.Counter;
import element.IElement;

public class TimSort extends Counter implements SortingAlgorithm{

	@Override
	public <T> void sort(IElement<T>[] a) {
		// TODO Auto-generated method stub
		
	}

	private int GetMinrun(int n)
	   {
	       int r = 0;           
	       while (n >= 64) {
	           r |= n & 1;
	           n >>= 1;
	       }
	       return n + r;
	   }
	
}
