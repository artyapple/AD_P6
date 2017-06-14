package sort;


import java.util.Arrays;

import counter.Counter;
import element.IElement;

public class CountingSort extends Counter implements SortingAlgorithm {

	@SuppressWarnings("rawtypes")
	public <T> void sort(IElement<T>[] a) {

		IElement[] aux = new IElement[a.length];

		// find the smallest and the largest value
		long minValue = a[0].getKey();
		long maxValue = a[0].getKey();
		for (int i = 1; i < a.length; i++) {
			if (a[i].getKey() < minValue) {
				minValue = a[i].getKey();
			} else if (a[i].getKey() > maxValue) {
				maxValue = a[i].getKey();
			}
		}

		// init array of frequencies
		int size = (int) (maxValue - minValue + 1);
		int[] counts = new int[size];

		// init the frequencies
		for (int i = 0; i < a.length; i++) {
			counts[(int) (a[i].getKey() - minValue)]++;
		}

		// recalculate the array - create the array of occurences
		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
		}

		/*
		 * Sort the array right to the left 1) Look up in the array of
		 * occurences the last occurence of the given value 2) Place it into the
		 * sorted array 3) Decrement the index of the last occurence of the
		 * given value 4) Continue with the previous value of the input array
		 * (goto set1), terminate if all values were already sorted
		 */
		for (int i = a.length - 1; i >= 0; i--) {
			aux[counts[(int) (a[i].getKey() - minValue)]--] = a[i];
		}
		a = Arrays.copyOf(aux, aux.length);;
	}
}
