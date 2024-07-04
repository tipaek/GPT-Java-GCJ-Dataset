import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
        	int N = in.nextInt();
        	int[][] matrix = new int[N][N];
        	for(int j = 0; j < N; j++)
        		for(int k = 0; k < N; k++) matrix[j][k] = in.nextInt();
        	
        	
        	Solution solution = new Solution(matrix);
        	System.out.println("Case #" + i + ": "+ solution.getSolution());
        }
    }
	
	private int[][] matrix;
	private int N;
	
	public Solution(int[][] matrix) {
		this.matrix = matrix;
		this.N = matrix.length;
		solve();
	}
	
	private void solve() {
		
		boolean[] rColumn = new boolean[N];
		boolean[] rRow = new boolean[N];
		
		HashMap<Integer, Integer>[] RowsHMs = new HashMap[N];
		HashMap<Integer, Integer>[] ColumnsHMs = new HashMap[N];
		for(int i = 0; i < N; i++) {
			RowsHMs[i] = new HashMap<Integer, Integer>();
			ColumnsHMs[i] = new HashMap<Integer, Integer>();
		}
		
		int trace = 0;
		
		for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) {
			Integer value = RowsHMs[i].get(matrix[i][j]);
			if(value == null) RowsHMs[i].put(matrix[i][j], 1);
			else 			  rRow[i] = true;
			
			value = ColumnsHMs[j].get(matrix[i][j]);
			if(value == null) ColumnsHMs[j].put(matrix[i][j], 1);
			else 			  rColumn[j] = true;
			
			if(i == j) trace += matrix[i][i];
		}
		
		int column = 0, row = 0;
		
		for(int i = 0; i < N; i++) {
			if(rRow[i]) row++;
			if(rColumn[i]) column++;
		}
		
		solution = "" + trace + " " + row + " " + column;
	}
	
	public String getSolution() {return solution;}
	private String solution;
}
