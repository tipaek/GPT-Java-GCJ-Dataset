import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int numOfRanks = scan.nextInt();
				int numOfSuits = scan.nextInt();
				System.out.println("Case #" + i + ": " + solve(numOfRanks, numOfSuits));
			}
		}
	}

	private static class Operation {
		int pileA;
		int pileB;

		public Operation(int pileA, int pileB) {
			this.pileA = pileA;
			this.pileB = pileB;
		}

		@Override
		public String toString() {
			return pileA + " " + pileB;
		}
	}

	private static String solve(int numOfRanks, int numOfSuits) {
		List<Operation> operations = order(numOfRanks, numOfSuits);
		StringBuilder sb = new StringBuilder();
		sb.append(operations.size());
		for (Operation op : operations) {
			sb.append('\n');
			sb.append(op);
		}
		return sb.toString();
	}

	private static List<Operation> order(int numOfRanks, int numOfSuits) {
		List<Operation> solution = new LinkedList<>();
		int a = (numOfRanks * numOfSuits) - numOfRanks;
		int b = (numOfRanks - 1);
		boolean run = true;
		while (run) {
			solution.add(new Operation(a, b));
			a--;
			if (b > 1) {
				b--;
			}
			run = (numOfRanks >= numOfSuits && a > 1) || (a > numOfRanks);
		}
		return solution;
	}

}
