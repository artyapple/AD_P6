package datagen;

import java.util.concurrent.ThreadLocalRandom;

import element.Element;
import element.IElement;

public class DataOnTheGap implements DataGenerator {

	// nextLong Returns a pseudorandom, uniformly distributed value between the
	// given least value (inclusive) and bound (exclusive). -> +1
	private final int ONE = 1;
	private int minFactor;
	private int maxFactor;
	private ThreadLocalRandom rand;

	public DataOnTheGap(int minFactor, int maxFactor) {
		this.minFactor = minFactor;
		this.maxFactor = maxFactor;
		rand = ThreadLocalRandom.current();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public IElement[] getArrayWithData(int size) {
		int min, max;
		min = minFactor*size;
		max = maxFactor*size;
		
		Element<String>[] d = new Element[size];
		for (int i = 0; i < size; i++) {
			d[i] = new Element<String>(rand.nextLong(min, max + ONE), "");
		}
		return d;
	}

}
