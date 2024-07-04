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
			
			
			
					
			System.out.print("Case #" + i + ": ");
			//finding k
			int trace = 0;
			for(int j = 0; j < N; j++) {
				trace+= matrix[j][j];
			}
			
			
			int r = 0;
			int c = 0;
			int[] nums = new int[N];
			for(int p = 0; p < N; p++) {
				nums[p] = p + 1;
			}
			
			boolean gogo = true;
			
			for(int R = 0; R < N; R++) {
				gogo = true;
					for( int C = 0; C < N; C++) {
						if(gogo == false) {
							//System.out.println("it broke");
							break;
						}

						for(int f = C + 1; f < N; f++) {
						
							if(matrix[R][f] == matrix[R][C]) {
								r++;
								gogo = false;
								//System.out.println("it got set to false");
								break;
							}
								
						}
				 }				
			}
			gogo = true;
			
			for(int C = 0; C < N; C++) {
				gogo = true;
				for( int R = 0; R < N; R++) {
					if(gogo == false) {
						//System.out.println("it broke");
						break;
					}

					for(int g = R + 1; g < N; g++) {
						if(matrix[R][C] == matrix[g][C]) {
							c++;
							gogo = false;
							//System.out.println("it got set to false");
							break;
						}
							
					}
			 }				
		}
						
			System.out.print(trace + " " + r + " " + c);
			System.out.println("");
		}
	}
}

