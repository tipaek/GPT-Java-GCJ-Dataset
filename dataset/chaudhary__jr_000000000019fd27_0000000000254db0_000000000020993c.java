	import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int p = 1; p <= t; ++p) {
        	int trace=0,r=0,c=0;
        	int n = in.nextInt();
        	int [][] arr = new int[n][n];
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			arr[i][j]=in.nextInt();
        			if(i==j) {
        				trace+=arr[i][j];
        			}
        		}
        	}
        	for(int i=0;i<n;i++) {
        		HashSet<Integer> rs=new HashSet<Integer>();
        		HashSet<Integer> cs=new HashSet<Integer>();
        		for(int j=0;j<n;j++) {
        			rs.add(arr[i][j]);
        			cs.add(arr[j][i]);
        		}
        		if(rs.size()!=n) {
        			r++;
        		}
        		if(cs.size()!=n) {
        			c++;
        		}
        		rs.clear();
        		cs.clear();
        	}
          System.out.println("Case #" + p + ": " + trace + " " + r + " " + c);
        }
      }
    }
