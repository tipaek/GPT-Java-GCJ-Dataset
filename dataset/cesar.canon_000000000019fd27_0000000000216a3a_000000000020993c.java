import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//Scanner in = new Scanner(new BufferedReader(new FileReader("p.txt")));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int casos = in.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int N = in.nextInt();
			int rows = 0;
			int cols = 0;
			
			int[][] mat = new int[N][N];
			int tz = 0;
			StringTokenizer tk; 
			
			for (int j = 0; j < N; j++) {
				int[] row = new int[101];
				boolean sr = false;
				for (int k = 0; k < N; k++) {
					
					int num = in.nextInt();
					mat[j][k] = num;
					row[num]++;
					if(j == k) {
						tz+=num;
					}
					
					if(row[num] > 1) sr = true; 
					
				}
				
				if(sr) rows++;
			}
			
			for (int j = 0; j < N; j++) {
				boolean sc = false;
				int[] col = new int[101];
				for (int k = 0; k < N; k++) {
					int num = mat[k][j];
					col[num]++;
					if(col[num] > 1 ) sc = true;
				}
				if (sc) cols++;
			}
			
			System.out.println("Case #"+(i+1)+": "+tz+" "+rows+" "+cols);
			
		}

	}

}
