import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	int T = in.nextInt();

    	for (int testCase = 1; testCase <= T; testCase++) {

    		int N = in.nextInt();

    		int[][] matrix = new int[N][N];

    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				matrix[i][j] = in.nextInt();
    			}
    		}

    		int trace = 0;

    		boolean[][] inRow = new boolean[N][N]; // row #; value-1
    		boolean[][] inCol = new boolean[N][N]; // row #; value-1

    		int repRows = 0, repCols = 0;

    		for (int i = 0; i < N; i++) {
    			trace += matrix[i][i];

    			// check row
    			for (int j = 0; j < N; j++) {
    				int value = matrix[i][j];
    				if (inRow[i][value - 1]) {
    					repRows++;
    					break;
    				} else {
    					inRow[i][value - 1] = true;
    				}
    			}

    			// check column
    			for (int j = 0; j < N; j++) {
    				int value = matrix[j][i];
    				if (inCol[i][value - 1]) {
    					repCols++;
    					break;
    				} else {
    					inCol[i][value - 1] = true;
    				}
    			}
    		}

    		System.out.println("Case #" + testCase + ": " + trace + " " + repRows + " " + repCols);
    	}
	}
}