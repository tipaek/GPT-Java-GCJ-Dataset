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
            inv[j] = new Interval(in.nextInt(), in.nextInt());
        }
        
        process(inv, n, k);
      
    }
  }
  
  private static void process(Interval[] inv, int n, int k) {
	    
	    Arrays.sort(inv, (i1, i2) -> (i1.s == i2.s) ? i1.e - i2.e : i1.s - i2.s);
	    
	    int c = inv[0].e;
	    int j = -1;
	    
	    StringBuilder result = new StringBuilder();
	    result.append('C');
	    
	    for(int i=1; i<n; i++) {
	        
	        if(inv[i].s < c && inv[i].s < j) {
	            System.out.println("Case #" + k + ": IMPOSSIBLE");
	            return;
	        }
	        
	        if(inv[i].s >= c) {
	            c = (c == -1) ? inv[i].e : Math.min(c, inv[i].e);
	            
	            result.append('C');
	        } else if(inv[i].s >= j) {
	            j = (j == -1) ? inv[i].e : Math.min(j, inv[i].e);
	            
	            result.append('J');
	        }
	    }
	    
	    System.out.println("Case #" + k + ": " + result);
	    
	}
}

class Interval {
    int s;
    int e;
    public Interval(int s, int e) {
        
        this.s = s;
        this.e = e;
    }
}