import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Input
		int t = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= t; i++) {
			
			
			
			int N = Integer.parseInt(in.readLine());
			
			int[][] matrix = new int[N][N];
			
			for(int x = 0; x < N; x++) {
				 StringTokenizer line = new StringTokenizer(in.readLine());
				for(int y = 0; y < N; y++) {
					matrix[x][y] = Integer.parseInt(line.nextToken());
				}
			}
			
			
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					System.out.println(matrix[y][x]);
				}
			}
					
			System.out.print("Case #" + i + ": ");
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
					}
						
			System.out.print(trace + " " + r + " " + c);
			System.out.println("");
		}
	}
}

