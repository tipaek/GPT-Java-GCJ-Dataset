/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c = 1; c <= t; c++) {
		    int n = sc.nextInt();
		    int[][] arr = new int[n][n];
		    int trace = 0;
		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < n; j++) {
		            arr[i][j] = sc.nextInt();
		            if(i == j) {
		                trace += arr[i][j];
		            }
		        }
		    }
		    int rows = 0, cols = 0;
		    for(int i = 0; i < n; i++) {
		        Set<Integer> setRow = new HashSet<>();
		        Set<Integer> setCol = new HashSet<>();
		        for(int j = 0; j < n; j++) {
		            setRow.add(arr[i][j]);
		            setCol.add(arr[i][j]);
		        }
		        if(setRow.size() != n) {
		            rows++;
		        }
		        if(setCol.size() != n) {
		            cols++;
		        }
		    }
		    System.out.println("Case #" + c + ": " + trace + " " + rows + " " + cols);
		}
	}
}
