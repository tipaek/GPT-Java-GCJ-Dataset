import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	static ArrayList<ArrayList> row = new ArrayList<ArrayList>();

	public static void main(String[] args) {
		// Scanner Object
		Scanner sc = new Scanner(System.in);

		// Test Case
		int T = sc.nextInt();

		// Loop for Test Cases
		for (int i = 0; i < T; i++) {
			// Clear the row to get new rows
			row.clear();
			// Get the size of the 2D Array
			int N = sc.nextInt();
			// Make Array
			MakeList(N);
			// Print Cases
			System.out.println("Case #" + (i + 1) + ": " + diagnosal() + " " + count_rows() + " " + count_columns());
		}
	}

	public static void MakeList(int N) {
		ArrayList<Integer> column = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		if (row.size() == N)
			return;

		else {
			String[] rows = sc.nextLine().split(" ");
			column.addAll(Arrays.stream(Arrays.asList(rows).stream().mapToInt(Integer::parseInt).toArray()).boxed()
					.collect(Collectors.toList()));
			row.add(column);
			MakeList(N);
		}
	}

	public static int count_rows() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int count = 0;

		for (int j = 0; j < row.size(); j++) {
			temp = row.get(j);
			for (int i = 0; i < temp.size() - 1; i++) {
				if (temp.get(j).equals(temp.get(i + 1)) && j != i + 1) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	public static int count_columns() {
		int count = 0, i = 0;

		for (int c = 0; c < row.size(); c++)
			for (int j = 0; j < row.size(); j++) {
				if (j == row.size() - 1 && i < row.size()-1) {
					j = 0;
					i++;
				}

				if (row.get(i).get(c).equals(row.get(j).get(c)) && j != i) {
					count++;
					i=0;
					break;
				}

			}

		return count;
	}

	public static int diagnosal() {
		int result = 0;
		for (int j = 0; j < row.size(); j++) {
			result += (int) row.get(j).get(j);
		}
		return result;
	}

}
