package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import element.Element;
import pivot.IPivotElement;
import pivot.PivotFirst;
import pivot.PivotMedian;
import pivot.PivotRandom;
import sort.BucketSort;
import sort.CountingSort;
import sort.QuickSort;
import sort.SortingAlgorithm;

public class SortTest {

	private IPivotElement p;
	private Element<String>[] array;
	private SortingAlgorithm alg;	
	private List<Element<String>[]> testData = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Before
	public void before() {
		for(long[] set : SortTestData.KEY_SETS){
			int i = 0;
			Element<String>[] testSet = new Element[set.length];
			for (long key : set) {
				testSet[i] = new Element<String>(key, SortTestData.TEST_ELEMENT_DATA);
				i++;
			}
			testData.add(testSet);
		}
	}

	@Test
	public void sortRandomPivot() {
		p = new PivotRandom();
		alg = new QuickSort(p);
		executeTests();
	}

	@Test
	public void sortMedianPivot() {
		p = new PivotMedian();
		alg = new QuickSort(p);
		executeTests();
	}

	@Test
	public void sortFirstPivot() {
		p = new PivotFirst();
		alg = new QuickSort(p);
		executeTests();
	}
	
	@Test
	public void sortEmpty() {
		p = new PivotFirst();
		alg = new QuickSort(p);
		array = null;
		alg.sort(array);
		assertNull(array);
	}
	
	@Test
	public void bucketSortInsertion() {
		alg = new BucketSort();
		executeTests();
	}
	
//	@Test
//	public void bucketSortCounting() {
//		SortingAlgorithm helper = new CountingSort();
//		alg = new BucketSort(helper);
//		executeTests();
//	}

	private void executeTests() {
		for(int i=0;i< SortTestData.TEST_TOTAL;i++){
			array = testData.get(i);
			alg.sort(array);
			testList(SortTestData.SORTED_KEY_SETS[i]);
		}
	}
	
	private void testList(long[] sortedKeys) {
		for (int i = 0; i < sortedKeys.length; i++) {
			assertEquals(sortedKeys[i], array[i].getKey());
		}
	}
}
