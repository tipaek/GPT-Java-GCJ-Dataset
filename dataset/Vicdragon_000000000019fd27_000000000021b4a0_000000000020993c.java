import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int mat[][] = new int[n][n];
        int rows = 0;
        int cols = 0;
        int trace = 0;
        for (int j=0; j<n; j++) {
            for (int k=0; k<n; k++) {
                mat[j][k] = in.nextInt();
                if (j == k)
                    trace += mat[j][k];
            }
        }
        for (int j=0; j<n; j++) {
            Set<Integer> checkrow = new HashSet<Integer>();
            Set<Integer> checkcol = new HashSet<Integer>();
            for (int k=0; k<n; k++) {
                checkrow.add(mat[j][k]);
                checkcol.add(mat[k][j]);
            }
            if (checkrow.size() < n)
                rows++;
            if (checkcol.size() < n)
                cols++;
        }
        System.out.println(String.format("Case #%s: %s %s %s", i, trace, rows, 
            cols));
    }
  }
}