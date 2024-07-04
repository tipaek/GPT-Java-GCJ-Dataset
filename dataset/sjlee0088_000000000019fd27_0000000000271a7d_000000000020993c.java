import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int n, trace, row, col;
		int[][] matrix;
		boolean[][] row_occupied;
		boolean[][] col_occupied;
		boolean[] rows;
		boolean[] cols;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			trace = 0;
			row = 0;
			col = 0;
			matrix = new int[n][n];
			row_occupied = new boolean[n][n+1];
			col_occupied = new boolean[n][n+1];
			rows = new boolean[n];
			cols = new boolean[n];
			
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					rows[i] |= row_occupied[i][matrix[i][j]];
					cols[j] |= col_occupied[j][matrix[i][j]];
					row_occupied[i][matrix[i][j]] = true;
					col_occupied[j][matrix[i][j]] = true;
				}
			}
			
			for (int i=0; i<n; i++) {
				trace += matrix[i][i];
				if (rows[i])
					row++;
				if (cols[i])
					col++;
			}
			
			bw.write("Case #" + test_case + ": " + trace + " " + row + " " + col + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}