import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     t  = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			Set<Integer> rows[]    = new HashSet[n];
			Set<Integer> columns[] = new HashSet[n];
			for (int j = 0; j < n; j++) {
				rows[j] = new HashSet<Integer>();
			}
			for (int j = 0; j < n; j++) {
				columns[j] = new HashSet<Integer>();
			}
			int sum=0;
			for (int row = 0; row < n; row++) {
				for (int column = 0; column < n; column++) {
					int num = sc.nextInt();
					rows[row].add(num);
					columns[column].add(num);
					if (row == column) {
						sum += num;
					}
				}
			}
			int dup_rows    = 0;
			int dup_columns = 0;
			for (int j = 0; j < n; j++) {
				if (rows[j].size() < n) {
					dup_rows++;
				}
				if (columns[j].size() < n) {
					dup_columns++;
				}
			}
			System.out.println("Case #" + i + ": " + sum + " " + dup_rows + " " + dup_columns);
		}
		sc.close();
	}
}
