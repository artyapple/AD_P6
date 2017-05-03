package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import datagen.DataGenerator;
import datagen.DataOnTheGap;
import element.Element;
import element.IElement;
import pivot.IPivotElement;
import pivot.PivotFirst;
import pivot.PivotMedian;
import pivot.PivotRandom;
import sort.QuickSort;
import sort.SortingAlgorithm;

public class Main {

	public static void main(String[] args) {
//		ComplexityAnalysis a = new ComplexityAnalysis();
//		a.avgCase();
//		//a.bestCaseMedianPivot();
//		//a.worstCaseFirstPivot();
		
		
//		long x = 700;
//		long y = 800;
//		
//		ThreadLocalRandom rand = ThreadLocalRandom.current();
//		
//		for(int i = 0; i <10; i++){
//			System.out.println(rand.nextLong(x, y+1));
//		}
		
		
		DataGenerator dg = new DataOnTheGap(700, 800);
		Element<String>[] data = (Element<String>[]) dg.getArrayWithData(100);
		for(Element<String> el : data){
			System.out.println(el.getKey());
		}
	}
}
