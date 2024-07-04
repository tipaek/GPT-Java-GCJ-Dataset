import java.util.*;
import java.io.*;
public class Solution {

	static int rows(int[][] arr) {
		int result = 0;
		int n = arr[0].length;
		for(int i=0; i<n; i++) {
			int[] count = new int[n];
			for(int j=0; j<n; j++) {
				if (count[arr[i][j]-1]>0) {
					result++;
					break;
				}
				count[arr[i][j]-1]++;
			}
		}
		return result;
	}

	static int columns(int[][] arr) {
		int result = 0;
		int n = arr[0].length;
		for(int i=0; i<n; i++) {
			int[] count = new int[n];
			for(int j=0; j<n; j++) {
				if (count[arr[j][i]-1]>0) {
					result++;
					break;
				}
				count[arr[j][i]-1]++;
			}
		}
		return result;
	}

	static int trace(int[][] arr) {
		int result = 0;
		int n = arr[0].length;
		for(int i=0; i<n; i++) {
			result += arr[i][i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] arr = new int[n][n]; 
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					arr[j][k] = in.nextInt();
				}
			}
			int result = rows(arr);
			System.out.println("Case #" + i + ": " + trace(arr) + " " + rows(arr) + " " + columns(arr));
		}
		in.close();
	}

}
