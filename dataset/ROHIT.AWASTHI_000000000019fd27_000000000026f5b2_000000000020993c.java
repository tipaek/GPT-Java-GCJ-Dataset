import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int l = 1; l <= t; ++l) {
		    int n = in.nextInt();
		    long k = 0;
		    Set<Integer> rowSet = null;
		    boolean checkRow = true;
		    int r = 0;
		    int c = 0;
		    List<Set<Integer>> colSetList = new ArrayList<>();
		    boolean[] doNotCheckCol = new boolean[n];
		    for(int i=0; i<n; i++) {
		    	checkRow = true;
		    	rowSet = new HashSet<>();
			    for(int j=0; j<n; j++) {
			    	int num = in.nextInt();
			    	if(i==j) {
			    		k += num;
			    	}
			    	if(checkRow) {
			    		if(rowSet.contains(num)) {
			    			checkRow = false;
			    			r++;
			    		} else {
			    			rowSet.add(num);
			    		}
			    	}
				    Set<Integer> colSet = null;
			    	if(colSetList.size()==j) {
			    		colSet = new HashSet<>();
			    		colSetList.add(colSet);
			    	} else {
			    		colSet = colSetList.get(j);
			    	}
			    	if(!doNotCheckCol[j]) {
			    		if(colSet.contains(num)) {
			    			doNotCheckCol[j] = true;
			    			c++;
			    		} else {
			    			colSet.add(num);
			    		}
			    	}
			    }
		    }
		    System.out.println("Case #" + l + ": " +k+" "+r+" "+c);
	    }
	    in.close();
	}

}
