import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        int n, cell;
	        Set<Integer> row;
	        Map<Integer, Set<Integer>> activeColumns = new HashMap<>();
	        
	        int duplicateRows, duplicateColumns, trace;
	        for (int i = 1; i <= t; ++i) {
	        	duplicateColumns = 0;
	        	duplicateRows = 0;
	        	trace = 0;
	        	
	        	n = in.nextInt();
	        	
	        	for( int r = 0; r < n; r++ ) {
	        		row = new TreeSet<>();
	        		for( int c = 0; c < n; c++ ) {
	        			if( r == 0 )
	        				activeColumns.put(c, new TreeSet<>());
	        				
	        			cell = in.nextInt();
	        			
	        			if( c == r )
	        				trace += cell;
	        			
	        			if( row != null && !row.add(cell) ) {
	        				duplicateRows++;
	        				row = null;
	        			}
	        			
	        			if( activeColumns.containsKey(c) && !activeColumns.get(c).add(cell) ) {
	        				duplicateColumns++;
	        				activeColumns.remove(c);
	        			}
	        		}
	        	}
	        	System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
	        }
	        
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
}
