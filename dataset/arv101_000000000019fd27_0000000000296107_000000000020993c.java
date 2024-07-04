import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// Input
		int t = in.nextInt();
		
		for(int i = 1; i <= t; i++) {
			
			System.out.print("Case #" + t + ": ");
			
			int N = in.nextInt();
			
			int[][] matrix = new int[N][N];
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					matrix[x][y] = in.nextInt();
				}
			}
			
			//finding k
			int trace = 0;
			for(int j = 0; j < N; j++) {
				trace+= matrix[j][j];
			}
			
			
			int r = 0;
			int c = 0;
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					if(y + 1 == N)
						break;
					if(matrix[x][y] == matrix[x][y + 1]) {
						c++;
						break;
					}
				}
			}
			
			
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					if(x + 1 == N)
						break;
					if(matrix[x][y] == matrix[x + 1][y]) {
						r++;
						break;
				}
			
			}
				System.out.println(r + " " + c);
		}

	}
}
}
