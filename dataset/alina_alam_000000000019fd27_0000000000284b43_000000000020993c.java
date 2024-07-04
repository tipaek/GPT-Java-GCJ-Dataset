import java.util.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // gather input
        int testcases = Integer.parseInt(scanner.nextLine());
        int[][][] arrays = new int[testcases][][];
        int[] sums = new int[testcases];
        int[] repeatedRows = new int[testcases];
        int[] repeatedCols = new int[testcases];
        
        for (int i = 0; i < testcases; i++) {
        	int arraySize = Integer.parseInt(scanner.nextLine());
        	arrays[i] = new int[arraySize][arraySize];
        	
        	for (int row = 0; row < arraySize; row++) {
        		String[] currentRow = scanner.nextLine().split(" ");
        		Set<Integer> rowTracker = new HashSet<>();
        		boolean isRepeated = false;
        		
        		for (int column = 0; column < arraySize; column++) {
        			arrays[i][row][column] = Integer.parseInt(currentRow[column]);
        			if (rowTracker.contains(arrays[i][row][column]) && !isRepeated) {
        				isRepeated = true;
        			}
        			else {
        				rowTracker.add(arrays[i][row][column]);
        			}
        			// this is a diagonal
        			if (row == column) {
        				sums[i] += arrays[i][row][column];
        			}
        		}
        		
        		if (isRepeated) {
        			repeatedRows[i]++;
        		}
        	}
        }
        
        // check columns for repeated values
        for (int i = 0; i < testcases; i++) {
        	for (int col = 0; col < arrays[i].length; col++) {
        		Set<Integer> colTracker = new HashSet<>();
        		boolean isRepeated = false;
        		
        		for (int row = 0; row < arrays[i].length; row++) {
        			if (colTracker.contains(arrays[i][row][col]) && !isRepeated) {
        				isRepeated = true;
        			}
        			else {
        				colTracker.add(arrays[i][row][col]);
        			}
        		}
        		
        		if (isRepeated) {
        			repeatedCols[i]++;
        		}
        	}
        }
        
        // print out sum and rows - Case #1: 4 0 0
        for (int i = 0; i < sums.length; i++) {
        	System.out.println("Case #" + (i + 1) + ": " + sums[i] + " " + repeatedRows[i] + " " + repeatedCols[i]);
        }
    }
}