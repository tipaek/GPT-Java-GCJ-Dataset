import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();

		for (int test = 0; test < T; test++) {
			int num = scan.nextInt();

			int row_count = 0;
			int column_count = 0;
			int diagonal_count = 0;

			int[][] arr = new int[num][num];
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					arr[i][j] = scan.nextInt();
					if (i == j) {
						diagonal_count += arr[i][j];
					}
				}
			}
			

			int out = 0;
			for (int i = 0; i < num; i++) {

				for (int j = 0; j < num; j++) {
					for(int k=j+1; k<num; k++) {
						if(arr[i][j]==arr[i][k]) {
							row_count++;
							out =1;
							break;
						}
					}
					if(out==1) {
						out=0;
						break;
					}
				}
				
				for (int j = 0; j < num; j++) {
					for(int k=j+1; k<num; k++) {
						if(arr[j][i]==arr[k][i]) {
							column_count++;
							out =1;
							break;
						}
					}
					if(out==1) {
						out=0;
						break;
					}
				}

				
			
			
			} 

			System.out.println("Case #" + (test + 1) + ": " + diagonal_count + " " + row_count + " " + column_count);
		}
	}
}