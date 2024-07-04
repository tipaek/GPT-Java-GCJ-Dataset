import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static long[][] pascal;
	
	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void generatePascalTriangle(int n) {
		pascal = new long[n+1][n+1];
		for (int line = 1; line <= n; line++) {
			long C = 1;
			for (int i = 1; i <= line; i++) {
				//System.out.print(C + " ");
				pascal[line][i] = C;
				C = C * (line - i) / i;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int MAX_N = 52;
		generatePascalTriangle(MAX_N);
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N, sum;
		List<Pair> pairs;
		boolean[][] visited;
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			pairs = new ArrayList<>();
			MAX_N = (N/2)+1;
			visited = new boolean[MAX_N+1][MAX_N+1];
			
			sum = N - 1;
			pairs.add(new Pair(1, 1));
			visited[1][1] = true;
			
			int i = 1, j = 1;
			long value = 0, maxValue = 0;

			Pair tPair;
			
			while (sum > 0) {
				//  (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1).
				//for(int j = i; j > 0; j--) {
					maxValue = 0;
					tPair = new Pair(0, 0);
					int r = i+1, k = j+1, ri = -1, ki = -1;
					if(r <= MAX_N && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						maxValue = value;
						ri = r;	ki = k;
					}
					
					r = i + 1; k = j;
					if(r <= MAX_N && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						value = pascal[r][k];
						if(value <= sum) {
							maxValue = value;
							ri = r;	ki = k;
						}
					}
					
					r = i; k = j + 1;
					if(r <= MAX_N && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						value = pascal[r][k];
						if(value <= sum) {
							maxValue = value;
							ri = r;	ki = k;
						}
					}
					
					r = i; k = j - 1;
					if(r <= MAX_N && k > 0 && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						value = pascal[r][k];
						if(value <= sum) {
							maxValue = value;
							ri = r;	ki = k;
						}
					}
					
					r = i - 1; k = j;
					if(r > 0 && r <= MAX_N && k > 0 && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						value = pascal[r][k];
						if(value <= sum) {
							maxValue = value;
							ri = r;	ki = k;
						}
					}
					
					r = i - 1; k = j - 1;
					if(r > 0 && r <= MAX_N && k > 0 && k <= MAX_N && pascal[r][k] <= sum && !visited[r][k] && pascal[r][k] > maxValue) {
						value = pascal[r][k];
						if(value <= sum) {
							maxValue = value;
							ri = r;	ki = k;
						}
					}
					
					
					if(ri > -1 && ki > -1 && !visited[ri][ki]) {
						i = ri;
						j = ki;
						visited[i][j] = true;
						sum -= maxValue;
						pairs.add(new Pair(i, j));
					}
				//}
			}
			
			System.out.println("Case #" + tc + ": ");
			for(Pair p: pairs) {
				System.out.println(p.x + " " + p.y);
			}
			
			//System.out.println(sum);
		}
		in.close();
	}
}
