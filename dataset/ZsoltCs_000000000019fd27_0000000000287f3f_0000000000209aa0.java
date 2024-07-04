import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int matrixSize = scan.nextInt();
				int trace = scan.nextInt();
				System.out.println("Case #" + i + ": " + solve(matrixSize, trace));
			}
		}
	}

	private static String solve(int matrixSize, int trace) {
		List<LatinSquare> squares = getReducedLatinSquares(matrixSize);
		for (LatinSquare square : squares) {
			if (trace == square.trace()) {
				return "POSSIBLE\n" + square.toString();
			}
		}
		return "IMPOSSIBLE";
	}

	private static class LatinSquare {

		int[][] square;
		int size;

		public LatinSquare(int n) {
			square = new int[n][n];
			size = n;
			for (int col = 0; col < n; col++) {
				set(0, col, col + 1);
			}
		}

		public LatinSquare(LatinSquare ls) {
			int n = ls.size;
			square = new int[n][n];
			size = n;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					set(row, col, ls.get(row, col));
				}
			}
		}

		public void set(int row, int col, int value) {
			square[row][col] = value;
		}

		public int get(int row, int col) {
			return square[row][col];
		}

		public int trace() {
			int sum = 0;
			for (int i = 0; i < size; ++i) {
				sum += get(i, i);
			}
			return sum;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					sb.append(get(row, col));
					if (col < size - 1) {
						sb.append(' ');
					}
				}
				sb.append("\n");
			}
			return sb.toString();
		}

	}

	private static class PermutationGenerator {

		private int[] a;
		private BigInteger numLeft;
		private BigInteger total;

		public PermutationGenerator(int n) {
			if (n < 1) {
				throw new IllegalArgumentException("Min 1");
			}
			a = new int[n];
			total = getFactorial(n);
			reset();
		}

		private void reset() {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			numLeft = new BigInteger(total.toString());
		}

		public boolean hasMore() {
			return numLeft.compareTo(BigInteger.ZERO) == 1;
		}

		private static BigInteger getFactorial(int n) {
			BigInteger fact = BigInteger.ONE;
			for (int i = n; i > 1; i--) {
				fact = fact.multiply(new BigInteger(Integer.toString(i)));
			}
			return fact;
		}

		public int[] getNext() {
			if (numLeft.equals(total)) {
				numLeft = numLeft.subtract(BigInteger.ONE);
				return a;
			}

			// Find largest index j with a[j] < a[j+1]
			int j = a.length - 2;
			while (a[j] > a[j + 1]) {
				j--;
			}

			// Find index k such that a[k] is smallest integer greater than a[j] to the
			// right of a[j]
			int k = a.length - 1;
			while (a[j] > a[k]) {
				k--;
			}

			// Interchange a[j] and a[k]
			int temp = a[k];
			a[k] = a[j];
			a[j] = temp;

			// Put tail end of permutation after jth position in increasing order
			int r = a.length - 1;
			int s = j + 1;
			while (r > s) {
				int temp2 = a[s];
				a[s] = a[r];
				a[r] = temp2;
				r--;
				s++;
			}

			numLeft = numLeft.subtract(BigInteger.ONE);
			return a;
		}
	}

	private static List<LatinSquare> getReducedLatinSquares(int n) {
		List<LatinSquare> squares = new ArrayList<>();

		squares.add(new LatinSquare(n));
		PermutationGenerator permGen = new PermutationGenerator(n);
		for (int fillRow = 1; fillRow < n; fillRow++) {
			List<LatinSquare> squaresNext = new ArrayList<>();
			for (LatinSquare square : squares) {
				while (permGen.hasMore()) {
					int[] perm = permGen.getNext();

					// If not the correct row - next permutation.
					if ((perm[0] + 1) != (fillRow + 1)) {
						continue;
					}

					// Check permutation against current square.
					boolean permOk = true;
					done: for (int row = 0; row < fillRow; row++) {
						for (int col = 0; col < n; col++) {
							if (square.get(row, col) == (perm[col] + 1)) {
								permOk = false;
								break done;
							}
						}
					}
					if (permOk) {
						LatinSquare newSquare = new LatinSquare(square);
						for (int col = 0; col < n; col++) {
							newSquare.set(fillRow, col, perm[col] + 1);
						}
						squaresNext.add(newSquare);
					}
				}
				permGen.reset();
			}
			squares = squaresNext;
		}
		return squares;
	}
}
