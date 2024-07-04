/* Use the slash-star style comments or the system won't see your
	identification information */
/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

public class Solution {
  public static void main (String [] args) throws IOException {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();
    in.nextLine();
    for (int i = 1; i <= cases; i++) {
    	int dems = in.nextInt();
    	in.nextLine();
    	int rowDub = 0;
    	int colDub = 0;
    	boolean row = false;
    	boolean col = false;
    	int trace = 0;
    	int[][] arr = new int[dems][dems];
    	for(int r = 0; r < dems; r++) {
    		for(int c = 0; c < dems; c++) {
    			arr[r][c] = in.nextInt();
    			if(!row) {
    				for(int x = 0; x < c; x++) {
        				if(arr[r][x] == arr[r][c]) {
        					rowDub++;
        					row = true;
        					break;
        				}
        			}
    			}
    		}
    		row = false;
    		trace += arr[r][r];
    	}
    	
    	for(int c = 0; c < dems; c++) {
    		for(int r = 0; r < dems; r++) {
    			if(!col) {
    				for(int x = 0; x < r; x++) {
        				if(arr[x][c] == arr[r][c]) {
        					colDub++;
        					col = true;
        					break;
        				}
        			}
    			}
    		}
    		col = false;
    	}
    	
    	System.out.println("Case #" + i + ": " + trace + " " + rowDub + " " + colDub);
    }
  }
}
