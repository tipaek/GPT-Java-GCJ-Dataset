import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k =0;k<t;k++) {
        	int n = in.nextInt();
        	int[][] ar =new int[n][n];
        	for(int i = 0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			int temp = in.nextInt();
        			ar[i][j]=temp;
        		}
        	}
        	
        	String sol = findSol(ar,n,k+1);
        	System.out.println(sol);
        	
          
        }
	}
	
	static String findSol(int[][] arr, int n, int caseNo) {
		String sol= "";
		int trace = 0;
		int rowCount =0;
		int columnCount =0;
		for(int i =0;i<n;i++) {
			boolean[] found = new boolean[n+1];
			boolean includeRow = false;
			for(int j=0;j<n;j++) {
				if(i==j) {
					trace+=arr[i][j];
				}if(found[arr[i][j]] == false) {
					found[arr[i][j]] = true;
				}else if(found[arr[i][j]] == true) {
					includeRow = true;
				}
			}
			if(includeRow) {
				rowCount++;
			}
		}
		
		for(int j=0;j<n;j++) {
			boolean[] found = new boolean[n+1];
			boolean includeColumn = false;
			for(int i =0;i<n;i++) {
				if(found[arr[i][j]] == false) {
					found[arr[i][j]] = true;
				}else if(found[arr[i][j]] == true) {
					includeColumn = true;
				}
			}
			if(includeColumn) {
				columnCount++;
			}
		}
		
		sol = "Case #"+caseNo+": "+trace+" "+rowCount+" "+columnCount;
		return sol;
        
    }
}