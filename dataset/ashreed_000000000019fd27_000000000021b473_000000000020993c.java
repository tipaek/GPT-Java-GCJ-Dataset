import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		List<int[]> listOfVals = new ArrayList<>();
		
		int currentN = 0;
		int rowIndex = 0;
		int currentTrace = 0;
		int currRepeatRows = 0;
		List<HashSet<Integer>> columns = new ArrayList<>();
		
		while (in.hasNextLine()) {
			// loop through all of the lines
			if (rowIndex < currentN) {
				int[] row = new int[currentN];
				for (int j = 0; j < currentN; j++) {
					row[j] = in.nextInt();
					columns.get(j).add(row[j]);
				}
				
				currentTrace += row[rowIndex];
				
				Set<Integer> rowSet = new HashSet<>(currentN);
				
				for (int j = 0; j < currentN; j++) {
					rowSet.add(row[j]);
				}
				
				if (rowSet.size() != currentN) {
					// no duplicates in a set, so if there aren't N items in the set
					// there's a duplicate in the row
					currRepeatRows++;
				}
				
				rowIndex++;
				
			} else {
				// matrix is done
				if (currentN != 0) {
					int[] previous = new int[3];
					previous[0] = currentTrace;
					previous[1] = currRepeatRows;
					
					int repeatCols = 0;
					for (int j = 0; j < currentN; j++) {
						if (columns.get(j).size() < currentN) {
							repeatCols++;
						}
					}
					
					previous[2] = repeatCols;
					listOfVals.add(previous);
				}
				
				rowIndex = 0;
				currentTrace = 0;
				currRepeatRows = 0;
				currentN = in.nextInt();
				columns.clear();
				
				for (int j = 0; j < currentN; j++) {	
					columns.add(new HashSet<Integer>());
				}
			}
			
		}
		
		int[] previous = new int[3];
		previous[0] = currentTrace;
		previous[1] = currRepeatRows;
		
		int repeatCols = 0;
		for (int j = 0; j < currentN; j++) {
			if (columns.get(j).size() < currentN) {
				repeatCols++;
			}
		}
		
		previous[2] = repeatCols;
		listOfVals.add(previous);
		
		for (int i = 0; i < testCases; i++) {
			// printing out all the cases
			int[] arrayOfVals = listOfVals.get(i);
			System.out.printf("Case #%d: %d %d %d\n", (i+1), arrayOfVals[0], arrayOfVals[1], arrayOfVals[2]);
		}
		
		in.close();
    }
}