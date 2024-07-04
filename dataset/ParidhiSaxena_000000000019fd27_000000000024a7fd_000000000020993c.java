/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			for (int i =0 ; i < n ; i++){
				String s []= br.readLine().split(" ");
				for (int j = 0; j < n; j++){
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			HashSet<Integer> set = new HashSet<>();
			int row = 0;
			//check each row
			for (int i = 0; i < n; i++) {
				set = new HashSet<>();
				for (int j = 0; j < n ; j++) {
					if (!set.contains(arr[i][j]))
						set.add(arr[i][j]);
				}
				if (set.size() != n) row++;
			}
			int column = 0;
			//check each column
			for (int j = 0; j < n; j ++) {
				set = new HashSet<>();
				for (int i = 0; i < n ; i++) {
					if (!set.contains(arr[i][j]))
						set.add(arr[i][j]);
				}
				if (set.size() != n) column++;
			}
			//trace
			int trace = 0;
			for (int i = 0; i < n;  i++)
				trace += arr[i][i];
			System.out.println("Case #"+test+": "+trace+" "+row+" "+column);
		}
	}
}