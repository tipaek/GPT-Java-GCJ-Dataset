import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args){
    	
    	
    	// System.out.println("Enter username");
    	Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = sc.nextInt();
        
        for(int i = 0; i< test_cases; i++){
           int n = sc.nextInt();
           sc.nextLine();
           int resRow = 0;
           int resColumn = 0;
           int trace = 0;
           String [][] rows = new String [n][n];
           boolean [] colsChecked = new boolean [n];
           HashSet<String> [] colsSet = new HashSet[n];
           for(int j = 0; j < n; j++){
    	    
        	String x = sc.nextLine();
    	    String [] row = x.split(" ");
    	    //System.out.println(x);
    	    
    	    //System.out.println(Arrays.asList(row));
    		rows[j] = row;
    		HashSet<String> rowSet = new HashSet<>(Arrays.asList(row));
    		if(rowSet.size() < row.length)
    		    resRow++;
    		
    		for(int k = 0; k< row.length; k++) {
    			if(colsSet[k] == null)
    				colsSet[k] = new HashSet<String>();
    			if(colsSet[k].contains(row[k]) && !colsChecked[k]){
    		        colsChecked[k] = true;
    		        resColumn++;
    		     }else {
    		    	 colsSet[k].add(row[k]);
    		     }
    		    
    			if(k == j)
    				trace += Integer.parseInt(rows[j][k]);
    		}
          }
           System.out.println("Case #" + (i+1) + ": " + trace + " " + resRow + " " + resColumn);
        }
    }
}