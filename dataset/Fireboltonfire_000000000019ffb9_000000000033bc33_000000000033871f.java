import java.util.*;
import java.io.*;

import java.util.function.Function;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    
	    for(int i=1;i<=t;i++){
	        int c = in.nextInt();
	        int d = in.nextInt();
	        int[] count = new int[c+1];
	        for(int j=2;j<=c;j++){
	            count[j] = (-1)*in.nextInt();
	        }
	        List<String> res = new ArrayList<>();
	        for(int j=0;j<d;j++){
	            int u = in.nextInt();
	            int v = in.nextInt();
	            res.add(""+Math.max(Math.abs(count[u]-count[v]),1));
	        }
	        System.out.println("Case #"+i+": "+String.join(" ",res));
	        
	    }
	    in.close();
	}
	
}