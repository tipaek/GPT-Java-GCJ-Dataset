import java.util.*;
    import java.io.*;
    public class Solution { 
    	public static void walk(int N) {
    		int r = 1;
    		int k = 1;
    		int s = 0;
    		while(s <N) {
    			System.out.println(r+ " " + k);
    			r++;
    			k++;
    			s++;
    		}
    	}
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt();
        	System.out.println("Case #" + i + ": ");
        	walk(n);
          }
      }
    }