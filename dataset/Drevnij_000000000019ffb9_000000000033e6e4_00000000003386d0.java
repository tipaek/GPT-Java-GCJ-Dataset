
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	int n = in.nextInt();  
		    
		    	int[] x = new int[n];
		    	int[] y = new int[n];
		    	
		    	for (int i=0; i<n; i++) {
		    		x[i] = in.nextInt();
		    		y[i] = in.nextInt();
		    	}
		    	
		    	double [][] slope = new double[n][n];
		    	
		    	for (int i=0; i<n; i++)
		    		for (int j=i+1; j<n; j++) {
		    			int run = (x[j]-x[i]);
		    			int rise= y[j]-y[i];
		    			slope[i][j] =run==0?999999999:(0.0+rise)/(0.0+run);
		    		}
		    	
		    	Map<Double, Integer> count = new HashMap<>();
		    	int max=0;
		    	double maxSlope=0.0;
		    	for (int i=0; i<n; i++)
		    		for (int j=i+1; j<n; j++) {
		    			if (count.containsKey(slope[i][j])) {
		    				int c = count.get(slope[i][j]);
		    				c++;
		    				if (c>max) {
		    					max=c;
		    					maxSlope=slope[i][j];
		    				}
		    				count.put(slope[i][j], c);
		    			} else {
		    				count.put(slope[i][j], 1);
		    				if (1>max) {
		    					max=1;
		    					maxSlope=slope[i][j];
		    				}
		    				}
		    		}
		    	
		    	Set<Integer> points = new HashSet<>();
		    	for (int i=0; i<n; i++)
		    		for (int j=i+1; j<n; j++) 
		    			if (slope[i][j]==maxSlope) {
		    				points.add(i);
		    				points.add(j);
		    			}

		    	
		    	int result = points.size()+2;
		    	if (result>n) result=n;
		    	
		    	System.out.println("Case #"+ xx+": "+result);

		    }
		}
	  

	  

}