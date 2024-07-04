import java.util.*;

public class Solution {
	public static void main(String... args) {
		Scanner scanner;
        scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
            int nums = scanner.nextInt();
            
            int trace = 0;
        	int val = 0;
            
        	HashSet<Integer> repeatedRows = new HashSet<>();
        	HashSet<Integer> repeatedCols = new HashSet<>();
        	        	
        	Object[] colsSetArray = new Object[nums];
        	for (int j = 0; j < nums; j++) {
        		colsSetArray[j] = new HashSet<Integer>();
        	}
        	
            for (int i = 0; i < nums; i++) {
            	HashSet<Integer> rowSet = new HashSet<>();
            	for (int j = 0; j < nums; j++) {
            		HashSet<Integer> colSet = (HashSet<Integer>)colsSetArray[j];
            			
            		val = scanner.nextInt();
            		if (i == j) trace += val;
            		
            		if (rowSet.contains(val)) {
            			repeatedRows.add(i);
            		}
            		rowSet.add(val);
            		
            		if (colSet.contains(val)) {
            			repeatedCols.add(j);
            		}
            		colSet.add(val);
            	}
            }

            // out
            System.out.println(String.format("#%d: %d %d %d", test + 1, trace, repeatedRows.size(), repeatedCols.size()));
        }
	}
}
