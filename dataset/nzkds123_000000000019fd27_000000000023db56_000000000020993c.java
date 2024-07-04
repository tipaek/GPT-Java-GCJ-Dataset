import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {

	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		Number of test cases
        int T = in.nextInt();
        
        for (int i = 1; i < T+1; ++i) {
//          NxN matrix
            int N = in.nextInt();
            
            int trace = 0; //trace
            int r = 0; //duplicated rows
            int c = 0; //duplicated columns
            
            boolean[] markedRow;
            boolean[] markedColumn;
            
            int[][] grid = new int[N][N];

            int num = 0;
            int currentRowSum = 0;
            int currentColumnSum = 0;
            
            for (int j = 0; j < N; ++j) {
            	markedRow = new boolean [N];
            	for (int k = 0; k < N; ++k) {
            		num = in.nextInt();
            		//Add trace
            		if (j == k)
            			trace += num;
            		//
            		grid[j][k] = num;
            		markedRow[num-1] = true;
            	}
            	for (int k = 0; k < N; ++k) {
            		if (markedRow[k] == false) {
            			++r;
            			break;
            		}
            	}
            	markedRow = null;
            }
            
            for (int j = 0; j < N; ++j) {
            	markedColumn = new boolean[N];
            	for (int k = 0; k < N; ++k) {
            		markedColumn[grid[k][j] - 1] = true;
            	}
            	
            	for (int k = 0 ; k < N; ++k) {
            		if (markedColumn[k] == false) {
            			++c;
            			break;
            		}
            	}
            	markedColumn = null;
            }
                        
            System.out.println("Case #"+ i + ": "+ trace + " " + r + " " + c);
            
            for (int j = 0; j < N; ++j) {
            	grid[j] = null;
            }
            grid = null;
        }
        in.close();
	}

}
