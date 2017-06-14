package sort;

import java.util.ArrayList;
import java.util.List;

import counter.Counter;
import element.Element;
import element.IElement;

public class BucketSort extends Counter implements SortingAlgorithm {

	// private int BUCKET_NUM = 10;

	@Override
	public <T> void sort(IElement<T>[] a) {
		incrCalls();
		if (a.length <= 1 || a == null) {
			return;
		}
		// if (a.length < 10) {
		// BUCKET_NUM = a.length;
		// }
		sort(a, a.length);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> void sort(IElement<T>[] a, int arrSize) {
		int bucketCnt = getBucketCount(arrSize);

		long minValue = a[0].getKey();
		long maxValue = a[0].getKey();
		for (int i = 1; i < a.length; i++) {
			if (a[i].getKey() < minValue) {
				minValue = a[i].getKey();
			} else if (a[i].getKey() > maxValue) {
				maxValue = a[i].getKey();
			}
		}

		// Initialise buckets
		int bucketS = (int) ((maxValue - minValue) / bucketCnt + 1);

		List<List<IElement<T>>> buckets = new ArrayList<List<IElement<T>>>(bucketCnt);
		for (int i = 0; i < bucketCnt; i++) {
			incrCompares();
			buckets.add(new ArrayList<IElement<T>>());
		}

		// Distribute input array values into buckets
		for (int i = 0; i < a.length; i++) {
			incrCompares();
			buckets.get(Math.toIntExact((a[i].getKey() - minValue) / bucketS)).add(a[i]);
		}

		// Sort buckets and place back into input array
		int currentIndex = 0;
		for (int i = 0; i < buckets.size(); i++) {
			IElement[] bucketArray = new IElement[buckets.get(i).size()];
			
			bucketArray = buckets.get(i).toArray(bucketArray);

			// if(helper==null){
			// insertionSort(bucketArray);
			// } else {

			countingSort(bucketArray);
			// helper.sort(bucketArray);
			// }

			for (int j = 0; j < bucketArray.length; j++) {
				a[currentIndex++] = bucketArray[j];
			}

			// for (int j = bucketArray.length-1; j >= 0; j--) {
			// a[currentIndex++] = bucketArray[j];
			// }
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertionSort(IElement[] array) {
		int i, j;
		long tmpKey;
		IElement<String> tmp;

		for (i = 1; i < array.length; i++) {
			incrCompares();
			tmpKey = array[i].getKey();
			tmp = new Element(tmpKey, array[i].getValue());
			for (j = i - 1; (j >= 0) && (array[j].getKey() < tmpKey); j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = tmp;

		}
	}

	@SuppressWarnings("rawtypes")
	private <T> void countingSort(IElement<T>[] array) {
		incrCalls();
		if (array == null || array.length <= 1) {
			return;
		}

		IElement[] aux = new IElement[array.length];

		// find the smallest and the largest value
		long minValue = array[0].getKey();
		long maxValue = array[0].getKey();
		for (int i = 1; i < array.length; i++) {
			if (array[i].getKey() < minValue) {
				minValue = array[i].getKey();
			} else if (array[i].getKey() > maxValue) {
				maxValue = array[i].getKey();
			}
		}

		// init array of frequencies
		int size = (int) (maxValue - minValue + 1);
		int[] counts = new int[size];

		// init the frequencies
		for (int i = 0; i < array.length; i++) {
			counts[(int) (array[i].getKey() - minValue)]++;
		}

		// recalculate the array - create the array of occurences
		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			//incrCompares();
			counts[i] = counts[i] + counts[i - 1];
		}

		for (int i = array.length - 1; i >= 0; i--) {
			incrCompares();
			aux[counts[(int) (array[i].getKey() - minValue)]--] = array[i];
		}
		System.arraycopy(aux, 0, array, 0, aux.length);
	}

	private int getBucketCount(int len) {
		int res;

		if (len >= 10 && len < 99)
			res = 5;
		else if (len >= 100 && len < 999)
			res = 25;
		else if (len >= 1000 && len < 9999)
			res = 100;
		else if (len >= 10000 && len < 99999)
			res = 500;
		else if (len >= 100000 && len < 999999)
			res = 1000;
		else if (len >= 1000000 && len < 9999999)
			res = 5000;
		else
			res = 1;

		return res;
	}

}
