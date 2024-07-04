import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= tc; ++t) {
      int n = in.nextInt();
      int[][] arr = new int[n][n]; // boot it up
      
      for(int i = 0;i < n; i++)
        for(int j = 0; j < n; j++){
            arr[i][j] = in.nextInt();
        }
      int[] rdup,cdup; // duplicator check
      int r = 0;
      boolean rfound = false, cfound = false;
      int c=0;
      int s = 0;
      for(int i = 0; i < n; i++){
        rdup = new int[n+1]; // clean it up
        cdup = new int[n+1]; // clean it up
        for(int j = 0; j < n; j++){
            if(i == j)
            s+= arr[i][j];
            
            if(rdup[arr[i][j]] >= 1) rfound = true;
            rdup[arr[i][j]]++; // increment row
            
            if(cdup[arr[j][i]] >=1) cfound = true;
            cdup[arr[j][i]]++;
        }
        if(rfound) r++;
        if(cfound) c++;
      }
      System.out.println("Case #" + t + " " + s+ " " + r+" "+c);
    }
  }
}