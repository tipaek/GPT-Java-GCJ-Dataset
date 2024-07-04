import java.util.Scanner;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		int size = 0;

		for(int i = 1; i <= cases; i++) {
			size = in.nextInt();
			int trace = 0;
			int r = 0;
			int c = 0;
			int val = 0;
			boolean flag = false;
			int[][] square = new int[size][size];
			for(int j = 0; j < square.length; j++) {
				for(int k = 0; k < square.length; k++) {
					square[j][k] = in.nextInt();
					if(j == k) {
						trace += square[j][k];
					}
				}
			}
			
			for(int j = 0; j < square.length; j++) {
				for(int k = 0; k < square.length; k++) {
					val = square[j][k];
					for(int l = k+1; l < square.length; l++) {
						if(val == square[j][l]) {
							r++;
							flag = true;
							break;
						}
					}
					if(flag) {
						flag = false;
						break;
					}
				}
			}
			
			for(int j = 0; j < square.length; j++) {
				for(int k = 0; k < square.length; k++) {
					val = square[k][j];
					for(int l = k+1; l < square.length; l++) {
						if(val == square[l][j]) {
							c++;
							flag = true;
							break;
						}
					}
					if(flag) {
						flag = false;
						break;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
			
			
		}
		
	}
	
	
	
}
