import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int[][] mm = new int[n][n]; 
        int k = 0;
        int r = 0;
        int c = 0;
        for (int j = 0; j < n; ++j) {
            int rr = 0;
            c = 0;
            for (int l = 0; l < n; ++l) {
                int cc = 0;
                int m = in.nextInt();
                if (j == l){
                    k+=m;
                }
                
                if (l > 0 && rr == 0) {
                    for (int ll = 0; ll < l; ++ll) {
                        if (mm[j][ll] == m) {
                            rr = 1;
                        }
                    }
                }
                
                if (j > 0) {
                    for (int jj = 0; jj < j; ++jj) {
                        if (mm[jj][l] == m) {
                            cc = 1;
                        }
                    }
                }
                c+=cc;
                mm[j][l] = m;
            }
            
            r+=rr;
        }
      
        System.out.println("Case #" + i + ": " + k + " " + r + " " + c );
    }
  }
}
    
    