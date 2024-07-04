
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args)   {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			LinkedList<Long> linkedList = new LinkedList<>();
			TreeMap<Long, Long> map = new TreeMap<>((o, t1) -> {
				long val1 = o;
				long val2 = t1;
				if (val1 == val2) {
					return 0;
				} else if (val1 > val2) {
					return 1;
				}
				return -1;
			});
			long slices = in.nextLong();
			long dinners = in.nextLong();
			for (int j = 1; j <= slices; j++) {
				long e = in.nextLong();
				linkedList.add(e);
				map.merge(e, 1l, Long::sum);
			}
			System.out.println("Case #" + i + ": " + cuts(slices, dinners, linkedList, map));
		}
	}

	public static long cuts(long slices, long dinners, LinkedList<Long> currentSlices, TreeMap<Long, Long> map) {
		LinkedHashMap<Long, Long> sortedByValue = new LinkedHashMap<>();

		map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedByValue.put(x.getKey(), x.getValue()));

		for (Long num : sortedByValue.values()) {
			if (num >= dinners) {
				return 0;
			}
		}

		if (slices == 1l) {
			return dinners - 1l;
		}


		long numOfCuts = 0l;
		while (true) {
			Long aLong = map.firstKey();

			for (Map.Entry<Long, Long> entries : map.entrySet()) {
				Long key = entries.getKey();
				if (key % aLong == 0 && key != aLong) {
					sortedByValue.merge(aLong, 2l, Long::sum);
				} else {
					numOfCuts += (long)Math.floor(key/aLong);
					sortedByValue.merge(aLong, numOfCuts, Long::sum);
				}
				for (Long num : sortedByValue.values()) {
					if (num >= dinners) {
						return numOfCuts;
					}
				}
			}
			map.remove(aLong);
		}
	}
}