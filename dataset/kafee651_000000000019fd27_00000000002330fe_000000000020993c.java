/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] arr = new int[n+1][n+1];
          int sum = 0;
          int r = 0;
          int c = 0;
            for(int j = 1;j <= n;j++){
                HashSet<Integer> hs = new HashSet<>();
          	    for(int k = 1;k <= n;k++){
                    arr[j][k] = in.nextInt();
                    hs.add(arr[j][k]);
                    if(k == j){
                        sum+= arr[j][k];
                    }
                }
                if(hs.size() != n){
                    r++;
                }
                hs.clear();
                  
            }
            for(int j = 1;j <= n;j++){
                HashSet<Integer> hs = new HashSet<>();
          	    for(int k = 1;k <= n;k++){
                    hs.add(arr[k][j]);
                }
                if(hs.size() != n){
                    c++;
                }
                hs.clear();
                  
            }
          System.out.println("Case #" + i + ": "+sum+" "+r+" "+c);
        }
	}
}

    
      