import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTestCases = Integer.parseInt(scanner.nextLine());
		for (int testCase = 0; testCase < numTestCases; testCase++) {
			int r = 0, c = 0;
			long k = 0;
			int N = Integer.parseInt(scanner.nextLine());
			
			String[][] cell = new String[N][N];
			Set<String>[] cols = new Set[N];
			Set<String>[] rows = new Set[N];
			for (int row = 0; row < N; row++) {
				cell[row] = scanner.nextLine().split(" ");
				cols[row] = new HashSet<>();
				rows[row] = new HashSet<>();
			}
			
			for (int row = 0; row < N; row++) {
				k += Long.parseLong(cell[row][row]);
				for (int col = 0; col < N; col++) {
					if (rows[row].contains(cell[row][col])) {
						r++;
						break;
					}
					rows[row].add(cell[row][col]);
				}
				
				for (int col = 0; col < N; col++) {
					if (cols[row].contains(cell[col][row])) {
						c++;
						break;
					}
					cols[row].add(cell[col][row]);
				}
			}
			
			System.out.println("Case #"+(testCase+1)+": " + k + " " + r + " " + c);
		}
	}
}