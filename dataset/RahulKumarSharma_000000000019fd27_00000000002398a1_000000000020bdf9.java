import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Pair implements Comparable<Pair>{

	private int start;

	private int end;

	public Pair(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}

	public boolean overLaps(Pair other) {

		boolean result = true;

		if((start >= other.end) || (other.start >= end)){
			result = false;
		}
		
		return result;
	}

	@Override
	public int compareTo(Pair other) {
		
		return (start - other.start) >= 0 ? 0 : -1;
	}
}

public class Solution {

	public static boolean listOverlaps(List<Pair> pairs, Pair pairToCheck) {

		boolean result = false;

		for (Pair pair : pairs) {
			if (pair.overLaps(pairToCheck)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			List<Pair> allPairs = new ArrayList<>();
			List<Pair> cPairs = new ArrayList<>();
			List<Pair> jPairs = new ArrayList<>();

			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				Pair pair = new Pair(sc.nextInt(), sc.nextInt());
				allPairs.add(pair);
			}

			boolean isPossible = true;
			
			List<Pair> sortedPairs = new ArrayList<>(allPairs);
			
			Collections.sort(sortedPairs);
			
			for (Pair pair : sortedPairs) {

				if (!listOverlaps(cPairs, pair)) {
					cPairs.add(pair);
				}

				else if (!listOverlaps(jPairs, pair)) {
					jPairs.add(pair);
				}

				else {
					isPossible = false;
					break;
				}
			}

			StringBuffer result = new StringBuffer();

			if (!isPossible) {
				result.append("IMPOSSIBLE");
			} else {
				for (Pair pair : allPairs) {
					if (cPairs.contains(pair)) {
						result.append("C");
					} else if(jPairs.contains(pair)){
						result.append("J");
					}
				}
			}

			System.out.println("Case #" + cs + ": " + result.toString());
		}

		sc.close();
	}
}
