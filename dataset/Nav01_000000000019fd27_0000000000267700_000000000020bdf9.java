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
	    	List<Integer> jL = new ArrayList<Integer>();
	    	List<Integer> jU = new ArrayList<Integer>();
	    	List<Integer> cL = new ArrayList<Integer>();
	    	List<Integer> cU = new ArrayList<Integer>();
	    	
	    	String res = "";
	    	
	    	for(int i=0;i<n;i++){
	    		int l = in.nextInt();
	    		int u = in.nextInt();
	    		String p ="";
	    		if(i == 0){
	    			jL.add(l);
	    			jU.add(u);
	    			p = "J";
	    		}else if(i == 1){
	    			cL.add(l);
	    			cU.add(u);
	    			p = "C";
	    		}else{
	    			boolean found = false;
	    			boolean between = false;
	    			for(int k=0;k<jL.size();k++){
	    				if(checkBetween(l, u, jL.get(k), jU.get(k))){
	    					between = true;
	    				}
	    			}
	    			if(!between){
	    				jL.add(l);
    	    			jU.add(u);
    	    			p="J";
    	    			found = true;
	    			}
	    			if(!found){
	    				between = false;
	    				for(int k=0;k<cL.size();k++){
		    				if(checkBetween(l, u, cL.get(k), cU.get(k))){
		    					between = true;
		    	    		//	break;
		    				}
		    			}
	    			
	    			if(!between){
	    				cL.add(l);
    	    			cU.add(u);
    	    			p="C";
    	    			found = true;
	    			}
	    		}
	    			if(!found){
	    				p="no";
	    			}
	    			
	    		}
	    		if(p.equals("no")){
	    			res = "IMPOSSIBLE";
	    		}else{
	    			res = res + p;
	    		}
	    	//	System.out.println("Case #" + c + ": " +res);
	    	}
	    	System.out.println("Case #" + c + ": " +res);
	    }
	  }
	
	private static boolean checkBetween(int n, int m, int L, int U){
		
		if(n < U && L < m){
			return true;
		}
		return false;
	}
}
