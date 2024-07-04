import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int c = 1; c <= t; ++c) {
	    	int n = in.nextInt();
	//    	List<Integer> jL = new ArrayList<Integer>();
	//    	List<Integer> jU = new ArrayList<Integer>();
	//    	List<Integer> cL = new ArrayList<Integer>();
	//    	List<Integer> cU = new ArrayList<Integer>();
	    	int[] jL = new int[n];
	    	int[] jU = new int[n];
	    	int[] cL = new int[n];
	    	int[] cU = new int[n];
	    	
	    	int cIndex = 0;
	    	int jIndex = 0;
	    	
	    	String res = "";
	    	
	    	for(int i=0;i<n;i++){
	    		int l = in.nextInt();
	    		int u = in.nextInt();
	    		String p ="";
	    		if(i == 0){
	    		//	jL.add(l);
	    		//	jU.add(u);
	    			jL[jIndex] = l;
	    			jU[jIndex] = u;
	    			jIndex++;
	    			p = "J";
	    		}else if(i == 1){
	    		//	cL.add(l);
	    		//	cU.add(u);
	    			cL[cIndex] = l;
	    			cU[cIndex] = u;
	    			cIndex++;
	    			p = "C";
	    		}else{
	    			boolean found = false;
	    			boolean between = false;
	    			for(int k=0;k<jIndex;k++){
	    				if(!checkBetween(l, u, jL[k], jU[k])){
	    					between = true;
	    					jL[jIndex] = l;
	    	    			jU[jIndex] = u;
	    	    			jIndex++;
	    	    			p="J";
	    	    			found = true;
	    				}
	    			}
	    			if(!between){
	    				
	    			}
	    			if(!found){
	    				between = false;
	    				for(int k=0;k<cIndex;k++){
		    				if(!checkBetween(l, u, cL[k], cU[k])){
		    					between = true;
		    					cL[cIndex] = l;
		    	    			cU[cIndex] = u;
		    	    			cIndex++;
		    	    			p="C";
		    	    			found = true;
		    	    		//	break;
		    				}
		    			}
	    			
	    			if(!between){
	    				
	    			}
	    		}
	    			if(!found){
	    				p="no";
	    				
	    			}
	    			
	    		}
	    		if(p.equals("no")){
	    			res = "IMPOSSIBLE";
	    			break;
	    		}else{
	    			res = res + p;
	    		}
	    	//	System.out.println("Case #" + c + ": " +res);
	    	}
	    	System.out.println("Case #" + c + ": " +res);
	    }
	  }
	
	private static boolean checkBetween(int n, int m, int L, int U){
		if(n == L && m == U){
			return true;
		}
		if(n <= L){
			if(m > L){
				return true;
			}
		}else if(L < n){
			if(U > n){
				return true;
			}
		}
		return false;
	}
}
