import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int k = 1; k <= t; ++k) {
        
        int n = in.nextInt();
        Interval[] inv = new Interval[n];
        
        for(int j=0; j<n; j++) {
            inv[j] = new Interval(in.nextInt(), in.nextInt(), j);
        }
        
        process(inv, n, k);
      
    }
  }
  
  private static void process(Interval[] inv, int n, int k) {
	    
	    Arrays.sort(inv, (i1, i2) -> (i1.s == i2.s) ? i1.e - i2.e : i1.s - i2.s);
	    
	    int c = inv[0].e;
	    int j = -1;
	    
	    char[] result = new char[n];
	    result[inv[0].index] = 'C';
	    
	    for(int i=1; i<n; i++) {
	       
	        
	        if(inv[i].s < c && inv[i].s < j) {
	            System.out.println("Case #" + k + ": IMPOSSIBLE");
	            return;
	        }
	        
	            
	        if(inv[i].s >= c) {
	            c = Math.max(c, inv[i].e);
	           
	           result[inv[i].index] = 'C';
	        } else if(inv[i].s >= j) {
	            j = Math.max(j, inv[i].e);
	            result[inv[i].index] = 'J';
	        }
	    }
	    
	    System.out.println("Case #" + k + ": " + String.valueOf(result));
	    
	}
}

class Interval {
    int s;
    int e;
    int index;
    public Interval(int s, int e, int index) {
        
        this.s = s;
        this.e = e;
        this.index = index;
    }
}