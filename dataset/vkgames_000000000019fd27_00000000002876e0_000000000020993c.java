

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int [][] grid = new int[n][n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					grid[j][k] = sc.nextInt()-1; //0 to n-1
				}
			}
			int [] count = new int[n];
			int rowrepeat = 0;
			int colrepeat = 0;
			for(int j=0;j<n;j++) {
				count = new int[n];
				for(int k=0;k<n;k++) {
					count[grid[j][k]]++;
					if(count[grid[j][k]]>1) {
						rowrepeat++;
						break;
					}
				}
			}
			for(int k=0;k<n;k++) {
				count = new int[n];
				for(int j=0;j<n;j++) {
					count[grid[j][k]]++;
					if(count[grid[j][k]]>1) {
						colrepeat++;
						break;
					}
				}
			}
			int trace = n;
			for(int j=0;j<n;j++) {
				trace+=grid[j][j];
			}
			System.out.println("Case #"+(i+1)+":"+ " "+trace+" "+rowrepeat+" "+colrepeat);
		}
		
	}
}
