import java.util.*;

public class Solution {

	public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int testCasesIterator = 1;
        int n = 0;
        int trace = 0, rows = 0, columns = 0;
    	int rowIter = 0, colIter = 0;
    	HashSet<Integer> rowSet;
    	ArrayList<HashSet<Integer>> colSets;
    	int temp = 0;
    	int [] rowCount, columnCount;
    	HashSet<Integer> colSet;
    	while(testCasesIterator <= testCases) {
        	n = sc.nextInt();
        	rowIter = 0; colIter = 0;
        	rowSet = new HashSet<>();
        	colSets = new ArrayList<>();
        	rowCount = new int[n]; columnCount = new int[n];
        	while (colIter < n) {
        		while (rowIter < n) {
        			temp = sc.nextInt();
        			if (rowIter == colIter) trace += temp;
        			if (colSets.size() < n) {
        				colSet = new HashSet<>();
        				colSet.add(temp);
        				colSets.add(colSet);
        			} else {
        				colSet = colSets.get(rowIter);
        				if (colSet.contains(temp)) {
        					columnCount[rowIter] = 1;
        				}
        				colSets.get(rowIter).add(temp);
        			}
        			if (rowSet.contains(temp)) {
        				rowCount[colIter] = 1;
        			}
        			rowSet.add(temp);
        			rowIter ++;
        		}
        		rowIter = 0;
            	rowSet = new HashSet<>();
        		colIter ++;
        	}
        	
        	for (int i : rowCount) rows += i;
        	for (int i : columnCount) columns += i;

        	System.out.println("Case #" + testCasesIterator + ": " + trace + " " + rows + " " + columns);
        	testCasesIterator ++;
        	trace = 0;
        	rows = 0;
        	columns = 0;
        }
        sc.close();
		
	}

}
