import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	StringTokenizer st;
        	int[][] arr = new int[n][n];
        	int trace = 0;
        	int repRow = 0;
        	int repCol = 0;
        	for (int j = 0; j < n; j++) {
        		st = new StringTokenizer(br.readLine());
        		int[] arrr = new int[n];
        		for (int k = 0; k < n; k++) {
        			int x = Integer.parseInt(st.nextToken());
        			arrr[k] = x;
        			arr[j][k] = x;
        		}
        		trace += arr[j][j];
        		Arrays.sort(arrr);
        		for (int m = 0; m < n; m++) {
        			if (arrr[m] != m + 1) {
        				repRow ++;
        				break;
        			}
        		}
        		
        	}
        	for (int k = 0; k < n; k++) {
    			int[] arrr = new int[n];
    			for (int j = 0; j < n; j++) {
    				arrr[j] = arr[j][k]; 
    			}
    			Arrays.sort(arrr);
    			for (int m = 0; m < n; m++) {
    				if (arrr[m] != m + 1) {
    					repCol++;
    					break;
    				}
    			}
    		}
        	
        	System.out.println("Case #" + (i+1) + ":" + trace + " " + repRow + " " + repCol);
        }
        
    }
}