import java.io.*;
import java.util.*;

public class Vestigium {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int tcase = 1;
		while(t-- > 0) {
			int n = Integer.valueOf(br.readLine());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			}
			int sum = (n * (n+1))/2, trace = 0;
			int[][] rowSum = new int[n][n];
			int[][] colSum = new int[n][n];
			int row,col;
			row = col = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					rowSum[i][arr[i][j]-1]+=1;
					colSum[j][arr[i][j]-1]+=1;
					if(i==j) {
						trace+=arr[i][j];
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(rowSum[i][j]>1) {
						row++;break;
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(colSum[i][j]>1) {
						col++;break;
					}
				}
			}
			System.out.println("Case #"+tcase+": "+trace+" "+row+" "+col);
			tcase++;
		}
	}

}
