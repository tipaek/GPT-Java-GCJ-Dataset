//Solution 
    
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = in.nextInt();
    for(int i = 0; i < numTestCases; i++) {
    	int size = in.nextInt();
    	int[][] array = new int[size][size];
    	for(int j = 0; j < size; j++) {
    		for(int k = 0; k < size; k++) {
    			array[j][k] = in.nextInt();
    		}
    	}
    	int numRowRepeat = rowRepeat(array, size);
    	int numColRepeat = colRepeat(array, size);
    	int latinTrace = traceOn(array, size);
    	System.out.println("Case #" + (i+1) + ": " + latinTrace + " " + numRowRepeat + " " + numColRepeat);
    }
	}

	private static int traceOn(int[][] array, int size) {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += array[i][i];
		}
		return sum;
	}

	private static int colRepeat(int[][] array, int size) {
		int col = 0;
		for(int i = 0; i < size; i++) {
			boolean repeat = false;
			for(int j = 0; j < size && !repeat; j++) {
				for(int k = j + 1; k < size; k++) {
					if(array[j][i] == array[k][i]) {
						col++;
						repeat = true;
						break;
					}
				}
			}
		}
		return col;
	}

	private static int rowRepeat(int[][] array, int size) {
		int row = 0;
		for(int i = 0; i < size; i++) {
			boolean repeat = false;
			for(int j = 0; j < size && !repeat; j++) {
				for(int k = j + 1; k < size; k++) {
					if(array[i][j] == array[i][k]) {
						row++;
						repeat = true;
						break;
					}
				}
			}
		}
		return row;
	}
}
	
	