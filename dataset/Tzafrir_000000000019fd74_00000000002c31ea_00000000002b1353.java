import java.io.FileNotFoundException;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	private int[][] pascal;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
		genPascal();
// 		tests();
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			String res = solve(scan);
			System.out.printf("Case #%d:\n%s\n", i, res);
			System.err.printf("Case #%d:\n%s\n", i, res);
		});
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private void genPascal() {
		pascal = new int[501][501];
		for (int row = 0; row < 501; row++) {
			pascal[row][0] = 1;
			for (int col = 1; col <= row; col++) {
				pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
			}
		}
	}

	private String solve(Scanner scan) {
		int sum = scan.nextInt();
		Set<Pos> visited = new HashSet<>();
		List<Pos> path = findPath(0, 0, sum, 500, visited);
		Collections.reverse(path);
		StringBuilder sb = new StringBuilder();
		path.forEach(s -> sb.append(s + "\n"));
		return sb.toString();
	}
	
	List<Pos> getneighbours(int row, int col) {
		List<Pos> res = new ArrayList<Pos>();
		for (int row1 = row - 1; row1 <= row + 1; row1++)
			for (int col1 = col - 1; col1 <= col + 1; col1++) {
				if ((row1 == row - 1 && col1 == col + 1) || (row1 == row + 1 && col1 == col - 1) || row1 < 0 || col1 < 0
						|| col1 > row1)
					continue;
				res.add(new Pos(row1, col1));
			}
		Collections.sort(res, (p1, p2) -> pascal[p2.row][p2.col] - pascal[p1.row][p1.col]);
		return res;
	}

	private List<Pos> findPath(int row, int col, int sum, int steps, Set<Pos> visited) {
		Pos current = new Pos(row, col);
		if (steps <= 0 || visited.contains(current) || sum - pascal[row][col] < 0)
			return null;

		if (sum - pascal[row][col] == 0) {
			List<Pos> path = new ArrayList<Pos>();
			path.add(new Pos(row, col));
			return path;
		}
		visited.add(current);
		for (Pos p : getneighbours(row, col)) {
			List<Pos> found = findPath(p.row, p.col, sum - pascal[row][col], steps - 1, visited);
				if (found != null) {
					found.add(current);
					return found;
				}
			}
		visited.remove(current);
		return null;
	}

	private void tests() {
		singleTest("1", "1 1\n");
		singleTest("4", "1 1\n2 1\n3 2\n");
		singleTest("501", "1 1\n" + "2 1\n" + "3 2\n" + "4 2\n" + "5 3\n" + "6 3\n" + "7 4\n" + "8 4\n" + "9 5\n"
				+ "10 5\n" + "10 6\n" + "9 6\n" + "9 7\n" + "9 8\n" + "10 9\n");
		singleTest("723", "1 1\n" + "2 1\n" + "3 2\n" + "4 2\n" + "5 3\n" + "6 3\n" + "7 4\n" + "8 4\n" + "9 5\n"
				+ "10 5\n" + "11 5\n" + "11 4\n" + "10 4\n" + "9 3\n" + "8 2\n");
		singleTest("1000000000", "1 1\n" + "2 1\n" + "3 2\n" + "4 2\n" + "5 3\n" + "6 3\n" + "7 4\n" + "8 4\n" + "9 5\n"
				+ "10 5\n" + "11 6\n" + "12 6\n" + "13 7\n" + "14 7\n" + "15 8\n" + "16 8\n" + "17 9\n" + "18 9\n"
				+ "19 10\n" + "20 10\n" + "21 11\n" + "22 11\n" + "23 12\n" + "24 12\n" + "25 13\n" + "26 13\n"
				+ "27 14\n" + "28 14\n" + "29 15\n" + "30 15\n" + "31 16\n" + "32 16\n" + "31 15\n" + "31 14\n"
				+ "30 14\n" + "29 13\n" + "28 12\n" + "27 11\n" + "26 10\n" + "26 9\n" + "25 8\n" + "25 7\n" + "25 6\n"
				+ "24 6\n" + "24 5\n" + "24 4\n" + "25 4\n" + "26 4\n" + "26 3\n" + "27 3\n" + "28 3\n" + "29 3\n"
				+ "30 3\n" + "31 3\n" + "32 3\n" + "32 2\n" + "33 2\n" + "32 1\n" + "31 1\n" + "30 1\n" + "29 1\n"
				+ "28 1\n" + "27 1\n" + "26 1\n" + "25 1\n" + "24 1\n" + "23 1\n" + "22 1\n" + "21 1\n" + "20 1\n");
	}
	
	private void singleTest(String input, String expected) {
		String result = solve(new Scanner(new StringReader(input))); 
		if (result.equals(expected))
			return;
		System.err.println("Wrong answer for:\n"+input);
		System.err.println("Got: "+result);
		System.err.println("Expected: "+expected);
		System.exit(1);
	}

	private static class Pos {
		private int row;
		private int col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
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
			Pos other = (Pos) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}

		public String toString() {
			return (row + 1) + " " + (col + 1);
		}
	}
}
