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
		    Set<Integer> setRow = new HashSet<>();
		    Set<Integer> setCol = new HashSet<>();
		    for(int i = 0; i < n; i++) {
		        int flag1 = 0, flag2 = 0;
		        for(int j = 0; j < n; j++) {
		            if(flag1 == 0 && setRow.contains(arr[i][j])) {
		                rows++;
		                flag1 = 1;
		            }
		            if(flag2 == 0 && setCol.contains(arr[j][i])) {
		                cols++;
		                flag2 = 1;
		            }
		            setRow.add(arr[i][j]);
		            setCol.add(arr[i][j]);
		        }
		        setRow.clear();
		        setCol.clear();
		    }
		    System.out.println("Case #" + c + ": " + trace + " " + rows + " " + cols);
		}
	}
}
