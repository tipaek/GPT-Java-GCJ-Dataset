

	import java.util.*;
	import java.io.*;
	public class Solution {
	  public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	        int n = in.nextInt();
	        int trace = 0;
	       
	        ArrayList<Set<Integer>> columns = new ArrayList<>();
	        int contColumns =0;
	        int contRows = 0;
	        for(int k=0;k<n;++k){
	        	Set<Integer> rows = new HashSet<>();
	            for(int j=0;j<n;++j){
	                if(k==0){
	                    Set<Integer> emptySet2 = new HashSet<>();
	                    columns.add(emptySet2);
	                }
	                int v = in.nextInt();
	                if(k==j){
	                    trace+=v;
	                }
	                columns.get(j).add(v);
	                rows.add(v);
	                
	            }
	            if(rows.size()!=n) {
	            	++contRows;
	            }
	        }
	        for(int q = 0; q<columns.size();++q) {
	        	if(columns.get(q).size()!=n) {
	        		++contColumns;
	        	}
	        }
	      System.out.println("Case #" + i + ": " + (trace) +" " + (contRows)+ " " + (contColumns));
	    }
	  }
	}
