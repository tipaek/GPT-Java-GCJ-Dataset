import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int k = 1; k <= t; k++) {
        int n = in.nextInt();
    
        Integer[][] m = new Integer[n][n];


        int trace = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {                
                m[i][j] = in.nextInt();
                if (i==j){
                    trace = trace + m[i][j];
                }
            }
        }
        
        int r = 0;
        for (int i=0; i<n; i++) {
            HashSet<Integer> set = new HashSet<>(); 
            for (int j=0; j<n; j++) {          
                if (set.contains(m[i][j])) {
                    r++;
                    break;
                } else {
                    set.add(m[i][j]);
                }
            }
        }

        int c = 0;
        for (int j=0; j<n; j++) {
            HashSet<Integer> set = new HashSet<>(); 
            for (int i=0; i<n; i++) {          
                if (set.contains(m[i][j])) {
                    c++;
                    break;
                } else {
                    set.add(m[i][j]);
                }
            }
        }

        System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
        //System.out.println(Arrays.deepToString(m));
    }
  }
}