
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	          int n = in.nextInt();
	          int arry[][] = new int[n][n];
	          int trace = 0;
	          int repeatValueRow = 0;
	          int repeatValueColumn = 0;
 	          
	          Set<Integer> rowNum = null;
	          Set<Integer> repeatedRow = new HashSet<>();
	          Set<Integer> repeatedColumn = new HashSet<>();
	          Map<Integer,Set<Integer>> columnSet = new HashMap<>();
	          for(int j=0; j <n;j++){
	        	  rowNum = new HashSet<>();
	        	  for(int k=0; k <n;k++){
	        		  arry[j][k] = in.nextInt();
	        		  if(j == k){
	        			  trace += arry[j][k];
	        		  }
	        		  if(rowNum.contains(arry[j][k])){
	        			  repeatedRow.add(j);
	        		  }else{
	        			  rowNum.add(arry[j][k]);
	        		  }
	        		  
	        		  if(!columnSet.containsKey(k)){
	        			  Set<Integer> columnNum = new HashSet<>();
	        			  columnNum.add(arry[j][k]);
	        			  columnSet.put(k, columnNum);
	        		  }else{
	        			  Set<Integer> columnNum = columnSet.get(k);
	        			  if(columnNum.contains(arry[j][k])){
	        				  repeatedColumn.add(k);
		        		  }else{
		        			  columnNum.add(arry[j][k]);
		        		  }
	        		  }
	        		  
	        	  }
	          }
	          repeatValueRow = repeatedRow.size();
	          repeatValueColumn = repeatedColumn.size();
	          System.out.println("Case #" + i + ": " + trace+" "+ repeatValueRow +" "+ repeatValueColumn);
	       }
	     in.close();
	}
}
