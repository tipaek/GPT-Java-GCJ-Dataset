/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
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
		    Set<Integer> set = new HashSet<>();
		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < n; j++) {
		            if(set.contains(arr[i][j])) {
		                rows++;
		                break;
		            }
		            set.add(arr[i][j]);
		        }
		        set.clear();
		    }
		    set.clear();
		    for(int i = 0; i < n; i++) {
		        for(int j = 0; j < n; j++) {
		            if(set.contains(arr[j][i])) {
		                cols++;
		                break;
		            }
		            set.add(arr[j][i]);
		        }
		        set.clear();
		    }
		    System.out.println("Case #" + c + ": " + trace + " " + rows + " " + cols);
		}
	}
}
