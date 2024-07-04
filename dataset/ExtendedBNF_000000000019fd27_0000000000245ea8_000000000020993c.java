import java.util.*;
public class Vestigium {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i = 0; i < tests; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			solve(s);
		}

	}
	
	public static void solve(Scanner s) {
		int k = 0, r = 0, c = 0;
		int N = s.nextInt();
		int[][] square = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				square[i][j] = s.nextInt();
				if(i == j) k += square[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			Set<Integer> row = new HashSet();
			for(int j = 0; j < N; j++) {
				row.add(square[i][j]);
			}
			if(row.size() != N) r++;
			row.clear();
		}
		
		for(int i = 0; i < N; i++) {
			Set<Integer> column = new HashSet();
			for(int j = 0; j < N; j++) {
				column.add(square[j][i]);
			}
			if(column.size() != N) c++;
			column.clear();
		}
		System.out.print(k + " " + r + " " + c);
		System.out.println();
	}

}
