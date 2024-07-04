import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static int getResult(ArrayList<Long> slices, int numPeople) {
		Collections.sort(slices, Comparator.reverseOrder());
		Map<Long, Integer> freq = new HashMap<>();
		for (long slice : slices) {
			freq.put(slice, freq.getOrDefault(slice, 0) + 1);
		}
		int maxFreq = Integer.MIN_VALUE;
		for (long slice : freq.keySet()) {
			maxFreq = Math.max(maxFreq, freq.get(slice));
		}
		if (maxFreq >= numPeople) return 0;
		if (numPeople == 2) return 1;
		if (maxFreq == 2) {
			int index = -1;
			for (int i = 0; i < slices.size() - 1; i++) {
				if (slices.get(i) == slices.get(i+1)) index = i;
			}
			if (index != 0) return 1;
			else return 2;
		} else {
			Set<Long> seen = new HashSet<>();
			for (long slice : slices) {
				if (seen.contains(slice * 2)) return 1;
				seen.add(slice);
			}
			return 2;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numSlices = scanner.nextInt();
			int numPeople = scanner.nextInt();
			ArrayList<Long> slices = new ArrayList<>();
			for (int j = 0; j < numSlices; j++) {
				slices.add(scanner.nextLong());
			}		
			System.out.println("Case #" + (i + 1) + ": " + getResult(slices, numPeople));
		}
	}
}