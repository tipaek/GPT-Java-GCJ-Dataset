import java.util.List;
import java.util.Scanner;

class Pair2 {

	private int start;

	private int end;

	private String assignedTo;

	public Pair2(int start, int end) {
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
		Pair2 other = (Pair2) obj;
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

	public boolean overLaps(Pair2 other) {

		boolean result = true;

		if ((start >= other.end) || (other.start >= end)) {
			result = false;
		}

		return result;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedTo() {
		return assignedTo;
	}
}

public class Solution {

	public static boolean listOverlaps(List<Pair2> pairs, Pair2 pairToCheck) {

		boolean result = false;

		for (Pair2 pair : pairs) {
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

			int n = sc.nextInt();

			Pair2[] pairs = new Pair2[n];

			for (int i = 0; i < n; i++) {
				Pair2 pair = new Pair2(sc.nextInt(), sc.nextInt());
				pairs[i] = pair;
			}

			boolean isPossible = false;

			for (int i = 0; i < (1 << n); i++) {

				Pair2[] cpairs = new Pair2[n];
				Pair2[] jpairs = new Pair2[n];
				int cidx = 0;
				int jidx = 0;

				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) == (1 << j)) {
						cpairs[cidx++] = pairs[j];
						pairs[j].setAssignedTo("C");
					} else {
						jpairs[jidx++] = pairs[j];
						pairs[j].setAssignedTo("J");
					}
				}

				if (!checkOverlap(cpairs) && !checkOverlap(jpairs)) {
					isPossible = true;
					break;
				}

			}

			StringBuffer result = new StringBuffer();

			if (!isPossible) {
				result.append("IMPOSSIBLE");
			} else {
				for (Pair2 pair : pairs) {
					result.append(pair.getAssignedTo());
				}
			}

			System.out.println("Case #" + cs + ": " + result.toString());
		}

		sc.close();
	}

	private static boolean checkOverlap(Pair2[] pairs) {

		boolean result = false;

		outer: for (int i = 0; i < pairs.length; i++) {
			for (int j = i + 1; j < pairs.length; j++) {
				if ((pairs[i] != null) && (pairs[j] != null))
					if (pairs[i].overLaps(pairs[j])) {
						result = true;
						break outer;
					}

			}
		}
		return result;
	}
}
