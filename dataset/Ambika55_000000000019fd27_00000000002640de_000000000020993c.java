import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = scn.nextInt();

			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = scn.nextInt();
				}
			}
			ArrayList<Integer> ans=trace(matrix,n);
			int tr = ans.get(0);
			int r = ans.get(1);
			int c = ans.get(2);

			System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);

		}
	}

	private static ArrayList<Integer> trace(int[][] matrix, int n) {

		int t = 0;
		int r = 0, c = 0;
		ArrayList<String> row = new ArrayList<>();
		ArrayList<String> col = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = "";
			String k = "";
			for (int j = 0; j < n; j++) {
				if (i == j)
					t += matrix[i][j];
				s += matrix[i][j];
				k += matrix[j][i];
			}
			row.add(s);
			col.add(k);
		}

//		System.out.println(row);
//		System.out.println(col);

		for (int i = 0; i < row.size(); i++) {
			String s = row.get(i);

			Set<Character> seen = new HashSet<>();

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);

				if (seen.contains(ch)) {
					r++;
					break;
				} else
					seen.add(ch);

			}

		}

		for (int i = 0; i < col.size(); i++) {
			String s = col.get(i);

			Set<Character> seen = new HashSet<>();

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);

				if (seen.contains(ch)) {
					c++;
					break;
				} else
					seen.add(ch);

			}

		}
		ans.add(t);
		ans.add(r);
		ans.add(c);

		return ans;
	}

}
