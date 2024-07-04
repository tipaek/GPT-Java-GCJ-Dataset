import java.util.*;
import java.io.*;
public class Solution1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; ++i) {
	    int N = in.nextInt();
	    int[][] M = new int[N][N];
	    int sum = 0;
	    int[] row = new int[N];
	    List<Integer> colList = new ArrayList<Integer>();
	    
	    int rr = 0;
	    int rc = 0;
	    for(int k=0;k<N;k++){
	    	boolean rep = false;
	    	List<Integer> rowList = new ArrayList<Integer>();
	    	for(int j=0;j<N;j++){
	    		int num = in.nextInt();
	    		if(!rep){
	    			if(rowList.contains(num)){
	    				rep = true;
	    				rr = rr + 1;
	    			}else{
	    				rowList.add(num);
	    			}
	    		}
	    		M[k][j] = num;
	    		int cr = k;
	    		if(!colList.contains(j) && k > 0){
	    			
	    			for(int p=0;p<k;p++){
		    			if(M[p][j] == num){
		    				colList.add(j);
		    				rc = rc + 1;
		    			}
		    		}
	    		}
	    		
	        	if(k == j){
	        		sum = sum + num;
	        	}
	        }
	    }
	    System.out.println("Case #" + i + ": " +sum + " " + rr + " " + rc);
    }
  }
  
  
}