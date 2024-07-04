import java.util.*;
    import java.io.*;
    public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num = 0;
		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			int[][] x = new int[N][N];
			//input
			for(int j = 0; j < N; j++){
				for(int k = 0; k < N; k++){
					x[j][k] = sc.nextInt();
				}
			}
			int trace = 0;
			int countC = 0;
			int countR = 0;
			for(int j = 0; j < N; j++){
				Set<Integer> column = new HashSet<Integer>();
				Set<Integer> row = new HashSet<Integer>();
				for(int k = 0; k < N; k++){
					if(j == k)trace += x[j][k];
					row.add(x[j][k]);
					column.add(x[k][j]);
				}
				if(column.size() != N)countC++;
				if(row.size() != N)countR++;
			}
			System.out.println("Case #"+(i+1)+": "+ trace+" " + countR+" " + countC);
		}
	}
}