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
	    	int[][] M = new int[n][n];
	    	int[] jL = new int[n];
	    	int[] jU = new int[n];
	    	int[] cL = new int[n];
	    	int[] cU = new int[n];
	    	for(int i=0;i<n;i++){
	    		M[i][0] = in.nextInt();
	    		M[i][1] = in.nextInt();
	    	}
	    	
	    	int cIndex = 0;
	    	int jIndex = 0;
	    	
	    	String res = "";
	    	
	    	for(int i=0;i<n;i++){
	    		int l = M[i][0];
	    		int u =  M[i][1];
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
	    				Interval arr1[] = { new Interval(l,u), new Interval(jL[k], jU[k])};
	    				if(isOverlap(arr1, 2)){
	    					between = true;
	    					break;
	    				}
	    			}
	    			if(!between){
	    				jL[jIndex] = l;
    	    			jU[jIndex] = u;
    	    			jIndex++;
    	    			p="J";
    	    			found = true;
	    			}
	    			if(!found){
	    				between = false;
	    				for(int k=0;k<cIndex;k++){
	    					Interval arr1[] = { new Interval(l,u), new Interval(cL[k], cU[k])};
	    					if(isOverlap(arr1, 2)){
		    					between = true;
		    					break;
		    				}
		    			}
	    			
	    			if(!between){
	    				cL[cIndex] = l;
    	    			cU[cIndex] = u;
    	    			cIndex++;
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
	
	static class Interval  
	{  
	    int start;  
	    int end; 
	    public Interval(int start, int end)  
	    { 
	        super(); 
	        this.start = start; 
	        this.end = end; 
	    }  
	};  
	
	static boolean isOverlap(Interval arr[], int n)  
	{  
	  
	    int max_ele = 0;  
	    for (int i = 0; i < n; i++) 
	    {  
	        if (max_ele < arr[i].end)  
	            max_ele = arr[i].end;  
	    }  
	    int []aux = new int[max_ele + 1]; 
	    for (int i = 0; i < n; i++)  
	    {  
	        int x = arr[i].start;  
	        int y = arr[i].end;  
	        aux[x]++; 
	        aux[y ]--;  
	    }  
	    for (int i = 1; i <= max_ele; i++) 
	    {  
	        aux[i] += aux[i - 1];  
	        if (aux[i] > 1)  
	            return true;  
	    }  
	    return false;  
	}  
}


