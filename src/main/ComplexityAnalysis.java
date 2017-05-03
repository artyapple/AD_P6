package main;

import java.util.ArrayList;
import java.util.List;

import element.Element;
import pivot.IPivotElement;
import pivot.PivotFirst;
import pivot.PivotMedian;
import pivot.PivotRandom;
import sort.QuickSort;
import sort.SortingAlgorithm;

public class ComplexityAnalysis {

	private List<Element<String>[]> dataSetsRand = new ArrayList<>();
	private List<Element<String>[]> dataSetsSorted = new ArrayList<>();
	
	private List<IPivotElement> pl = new ArrayList<>();
	private SortingAlgorithm alg;

	private final int ns[] = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
	private int tn[] = new int[ns.length*3];


	public ComplexityAnalysis() {
		pl.add(new PivotFirst());
		pl.add(new PivotMedian());
		pl.add(new PivotRandom());
		initDataSet();
	}

	public void avgCase() {
		
		int i = 0;
		
		System.out.println("=== AVG CASE ===");
		for (IPivotElement p : pl) {
			alg = new QuickSort(p);
			
			System.out.println("\n"+"= Pivot: " + p.getName()+" =");
			
			for (Element<String>[] testData : dataSetsRand) {
				Element<String>[] data = testData;
				alg.sort(data);
				System.out
						.format("N = " + data.length + " tiefe %d, swap %d, compare %d",
								alg.getCallsCounter(), alg.getSwapCounter(), alg.getCompareCounter())
						.println();
				tn[i++] = (alg.getCallsCounter()+alg.getCompareCounter());
				alg.resetCounter();
			}
		}
		//printForMatlab();
	}
	
	public void bestCaseMedianPivot(){
		System.out.println("\n"+"=== BEST CASE "+" Pivot: " + pl.get(1).getName()+ " ===");	
		alg = new QuickSort(pl.get(1));
		for (Element<String>[] testData : dataSetsSorted) {
			Element<String>[] data = testData;
			alg.sort(testData);
			System.out
					.format("N = " + data.length + "; T(N)="+(alg.getCallsCounter()+ alg.getCompareCounter()))
					.println();
			
			alg.resetCounter();
		}
	}
	
	public void worstCaseFirstPivot(){
		System.out.println("=== WORST CASE FIRST ===");	
		alg = new QuickSort(pl.get(0));
		System.out.println("\n"+"= Pivot: " + pl.get(0).getName()+" =");
		for (Element<String>[] testData : dataSetsSorted) {
			Element<String>[] data = testData;
			alg.sort(data);
			System.out
					.format("N = " + data.length + "; T(N)="+(alg.getCallsCounter()+ alg.getCompareCounter()))
					.println();
			
			alg.resetCounter();
		}
	}
	private void initDataSet() {
		for (int n : ns) {
			dataSetsRand.add(initDataRandom(n));
			dataSetsSorted.add(initDataSorted(n));
		}
	}

	private Element<String>[] initDataRandom(int n) {
		Element<String>[] d = new Element[n];
		for (int i = 0; i < n; i++) {
			d[i] = new Element<String>((long) (Math.random() * n), "");
		}
		return d;
	}
		
	private Element<String>[] initDataSorted(int n) {
		Element<String>[] d = new Element[n];
		for (int i = 0; i < n; i++) {
			d[i] = new Element<String>((long) i, "");
		}
		return d;
	}
	
	private void printForMatlab(){		
		for(int t : tn){
			System.out.print(t+" ");
		}
		
	}

}
