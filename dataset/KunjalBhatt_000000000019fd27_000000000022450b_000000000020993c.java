
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	          Map<Integer, Map<Integer,Integer>> columnFrequncy = new HashMap<Integer, Map<Integer,Integer>>();
	          Map<Integer, Map<Integer,Integer>> rowFrequncy = new HashMap<Integer, Map<Integer,Integer>>();
 	          
	          for(int j=0; j <n;j++){
	        	  for(int k=0; k <n;k++){
	        		  arry[j][k] = in.nextInt();
	        		  if(j == k){
	        			  trace += arry[j][k];
	        		  }
	        		 
	        		  Map<Integer,Integer> columnMap = null;
	        		  if(!columnFrequncy.containsKey(k)){
	        			  columnFrequncy.put(k, new HashMap<Integer,Integer>());
	        		  }
	        		  columnMap = columnFrequncy.get(k);
	        		  if(!columnMap.containsKey(arry[j][k])){
	        			  columnMap.put(arry[j][k], 1);
	        		  }else{
	        			  columnMap.put(arry[j][k],columnMap.get(arry[j][k])+1);
	        		  }
	        		  
	        		  Map<Integer,Integer> rowMap = null;
	        		  if(!rowFrequncy.containsKey(j)){
	        			  rowFrequncy.put(j, new HashMap<Integer,Integer>());
	        		  }
	        		  rowMap = rowFrequncy.get(j);
	        		  if(!rowMap.containsKey(arry[j][k])){
	        			  rowMap.put(arry[j][k], 1);
	        		  }else{
	        			  rowMap.put(arry[j][k],rowMap.get(arry[j][k])+1);
	        		  }
	        	  }
	          }
	          repeatValueColumn = getRepeatedCount(columnFrequncy);
	          repeatValueRow = getRepeatedCount(rowFrequncy);
	          System.out.println("Case #" + i + ": " + trace+" "+ repeatValueRow +" "+ repeatValueColumn);
	       }
	     in.close();
	}
	
	static int getRepeatedCount(Map<Integer,Map<Integer,Integer>> map){
		int maxRepeat = 1;
		
		for(Map.Entry<Integer,Map<Integer,Integer>> numFreqMap : map.entrySet()){
			for(Map.Entry<Integer, Integer> numFreq : numFreqMap.getValue().entrySet()){
				int fq = numFreq.getValue();
				if(maxRepeat < fq){
					maxRepeat = fq;
				}
			}
		}
		
		return maxRepeat == 1 ? 0 : maxRepeat;
	}


}
