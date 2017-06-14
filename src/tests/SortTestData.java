package tests;

public class SortTestData {
	
	public static final int TEST_TOTAL = 2;
	
	public static final String TEST_ELEMENT_DATA = "";
	
	private static final long TEST_KEYS_S1[] = new long[] { 1, 0, 11, 22, 4, 8, 12, 9, 2, 3, 5 };
	private static final long SORTED_KEYS_S1[] = new long[] { 0, 1, 2, 3, 4, 5, 8, 9, 11, 12, 22 };
	
	private static final long TEST_KEYS_S2[] = new long[] { 4, 0, 1, -1, 0, 2, -5, 0, 4, 8 };
	private static final long SORTED_KEYS_S2[] = new long[] { -5, -1, 0, 0, 0, 1, 2, 4, 4, 8 };
	
	private static final long TEST_KEYS_S3[] = new long[] { 0, 1000000000, 1, 500000000};
	private static final long SORTED_KEYS_S3[] = new long[] {0, 1, 500000000, 1000000000};
	
	public static final long[][] KEY_SETS = {TEST_KEYS_S1,TEST_KEYS_S2,TEST_KEYS_S3};
	public static final long[][] SORTED_KEY_SETS = {SORTED_KEYS_S1, SORTED_KEYS_S2, SORTED_KEYS_S3};
}
