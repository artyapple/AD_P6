package counter;

public class Counter {

	private int calls;
	private int swaps;
	private int compares;

	public int getCallsCounter() {
		return calls;
	}

	public int getSwapCounter() {
		return swaps;
	}

	public int getCompareCounter() {
		return compares;
	}

	public void incrCalls() {
		calls++;
	}

	public void incrCompares() {
		compares++;
	}

	public void incrSwaps() {
		swaps++;
	}

	public void resetCounter() {
		calls = 0;
		swaps = 0;
		compares = 0;
	}
}
