import java.util.Scanner;
import java.util.ArrayList;

public class Vestigium {
	static ArrayList<ArrayList> row = new ArrayList<ArrayList>();
	static int c = 0;

	public static void main(String[] args) {
		// Scanner Object
		Scanner sc = new Scanner(System.in);

		// Test Case
		int T = sc.nextInt();

		// Loop for Test Cases
		for (int i = 0; i < T; i++) {
			// Clear the row to get new rows
			row.clear();
			// Reset c
			c = 0;
			// Get the size of the 2D Array
			int N = sc.nextInt();
			// Make Array
			MakeList(N);
			//Print Cases
			System.out.println("Case #" + (i + 1) + ": " + diagnosal() + " " + count_rows() + " " + count_columns());
		}
	}

	public static void MakeList(int N) {
		ArrayList<Integer> column = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		if (c == N)
			return;

		else {
			String rows = sc.nextLine();
			String[] splits = rows.split(" ");
			for (int i = 0; i < N; i++)
				column.add(Integer.parseInt(splits[i]));
			row.add(c, column);
			c++;
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
		int count = 0, i =0;

			for (int j = 0; j < row.size(); j++) {
				for (int c = 0; c < row.size(); c++) {
					i=0;
					if (row.get(j).get(i).equals(row.get(c).get(i)) && j != c) {
						count++;
						break;
					}
					i++;
				}
			}

		return count;
	}

	public static int diagnosal() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int result = 0;
		for (int j = 0; j < row.size(); j++) {
			temp = row.get(j);
			for (int i = j; i < row.get(j).size(); i++) {
				result += temp.get(i);
				break;
			}
		}

		return result;
	}

}
