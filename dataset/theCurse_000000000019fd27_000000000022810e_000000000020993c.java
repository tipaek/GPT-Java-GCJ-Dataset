import java.util.*;
import java.io.*;

class Solution {
    public static void main (String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            Map<Integer, Set<Integer>> rowSet = new HashMap<>();
            Map<Integer, Set<Integer>> colSet = new HashMap<>();
            boolean[] rows = new boolean[n];
            boolean[] cols = new boolean[n];
            
            int row = 0, col = 0, trace = 0;
            for(int j=0; j<n; j++) {
            	for(int k=0; k<n; k++) {
            		
            		int num = in.nextInt();
            		
            		if(j == k) {
            			trace += num;
            		}
            		
            		Set<Integer> temp = rowSet.getOrDefault(j, new HashSet<>());
            		if(temp.contains(num) && !rows[j]) {
            			rows[j] = true;
            			row++;
            		} else {
            			temp.add(num);
            			rowSet.put(j, temp);
            		}
            		
            		Set<Integer> temp1 = colSet.getOrDefault(k, new HashSet<>());
            		if(temp1.contains(num) && !cols[k]) {
            			cols[k] = true;
            			col++;
            		} else {
            			temp1.add(num);
            			colSet.put(k, temp1);
            		}
            	}
            }
            
            System.out.println("Case #"+ i + ": " + trace + " " + row + " " + col);
		}
	}
}