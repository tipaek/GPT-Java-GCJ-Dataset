import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	static ArrayList<ArrayList> column = new ArrayList<ArrayList>();
	static ArrayList<ArrayList> row = new ArrayList<ArrayList>();
	static int c = 0;

	private static void MakeList(int N) {
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

	public static int countRows() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int count = 0;

		for (int j = 1; j < row.size(); j++) {
			temp = row.get(j);
			for (int i = 0; i < temp.get(i); i++) {
				if (temp.get(j).equals(temp.get(i)) && j != i) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	public static int countColumns() {
		int count = 0;
		int i = 0;
		for (int j = 1; j < row.size(); j++) {
			for (int c = 0; c < row.size() - 1; c++) {
				if (row.get(j).equals(row.get(c).get(i)) && j != c) {
					count++;
					break;
				}
			}
			i++;
		}
		return count;
	}

	public static int diagonsal() {
		int result = 0;
		for (int j = 0; j < row.size(); j++) {
			result = result + (int) row.get(j).get(j);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int i = 0; i < T; i++) {
			row.clear();
			c = 0;
			int N = scan.nextInt();
			MakeList(N);
			System.out.println("Case #" + (i + 1) + ": " + diagonsal() + " " + countRows() + " " + countColumns());
		}
	}
}