package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datagen.DataGenerator;
import datagen.DataOnTheGap;
import element.Element;
import pivot.IPivotElement;
import pivot.PivotMedian;
import sort.BucketSort;
import sort.CountingSort;
import sort.QuickSort;
import sort.SortingAlgorithm;

public class ComplexityAnalysisLabor6 {

	private List<Element<String>[]> dataSetsRand = new ArrayList<>();
	private List<List<String>> matlabQS = new ArrayList<>();
	private List<List<String>> matlabBS = new ArrayList<>();

	private IPivotElement p;
	private SortingAlgorithm qs;
	private SortingAlgorithm bs;

	private final String QSORT = "QuickSort";
	private final String BSORT = "BucketSort";
	private final int ns[] = { 10, 100, 1000, 10000, 100000, 1000000 };

	public ComplexityAnalysisLabor6() {
		p = new PivotMedian();
		qs = new QuickSort(p);
		bs = new BucketSort();
		initDataSet();
	}

	public void avgCase() {

		for (Element<String>[] testData : dataSetsRand) {
			Element<String>[] data = Arrays.copyOf(testData, testData.length);
			
			execute(qs, data, QSORT);
			execute(bs, testData, BSORT);
			
			
			
			
		}
	}

	public void prepareDataForMatlab(){
		
		for(int i =0; i<10;i++){
			initDataSet();
			for (Element<String>[] testData : dataSetsRand) {
				executeForMatlab(bs, testData, BSORT);
				executeForMatlab(qs, testData, QSORT);	
			}
		}
		
		
		
	}
	
	private void execute(SortingAlgorithm alg, Element<String>[] data, String label) {
		alg.sort(data);
		System.out
				.format(label+": N = " + data.length + " counter: %d", alg.getCallsCounter()+alg.getCompareCounter())
				.println();
		// tn[i++] = (alg.getCallsCounter() + alg.getCompareCounter());
		alg.resetCounter();
	}
	
	private void executeForMatlab(SortingAlgorithm alg, Element<String>[] testData, String label){
		int cntr;
		Element<String>[] data = testData;
		alg.sort(data);
		cntr = alg.getCallsCounter()+alg.getCompareCounter();
		
		alg.resetCounter();
	}

	private void initDataSet() {
		DataGenerator dg = new DataOnTheGap(700, 800);
		for (int n : ns) {
			dataSetsRand.add((Element<String>[]) dg.getArrayWithData(n));
		}
	}

	public void test(int n) {
		DataGenerator dg = new DataOnTheGap(700, 800);
		Element<String>[] data = (Element<String>[]) dg.getArrayWithData(n);
		
		SortingAlgorithm s = new BucketSort();
		s.sort(data);
		
//		BucketSort b = new BucketSort();
//		b.insertionSort(data);
		
		System.out.println("-----");
		for (Element<String> el : data) {
			System.out.println(el.getKey());
		}
	}

}
