import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		for (long T = 1; T <= t; ++T) {
			int n = in.nextInt(), d = in.nextInt();
			long[] arr = new long[n];
			HashMap<Long, Long> mp = new HashMap<>();
	    	for (int i = 0; i < n; ++i) {
	    		arr[i] = in.nextLong();
	    		if (mp.containsKey(arr[i])) mp.replace(arr[i], mp.get(arr[i])+1);
	    		else mp.put(arr[i], 1l);
	    	}
	    	
	    	long maxa = 0;
	    	for (long val : mp.values()) 
	    		if (val > maxa) maxa = val;
	    	
	    	Arrays.sort(arr);
	    	long f = 0l;
	    	
	    	for (int i = 0; i < n; ++i)
	    		for (int j = i+1; j < n; ++j)
	    			if (arr[j] == 2*arr[i]) f=1;
			
	    	long ans;
	    	if (d == 2 || d == 1) ans = d-maxa;
	    	else {
	    		long o = 1;
	    		if (f==1) ans = Math.min(d-maxa, o);
	    		else ans = d-maxa;
	    	}
    		System.out.println("Case #" + T + ": " + ans);
		}
	}
}