import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int k = 1; k <= t; ++k) {
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      int trace = 0;
      int r = 0;
      int c = 0;
      for(int i = 0; i<n;i++) {
        Set<Integer> set = new HashSet<>();
        for(int j=0;j<n;j++){
            matrix[i][j] = in.nextInt();
            set.add(matrix[i][j]);
            if(i==j) {
                trace+=matrix[i][j];
            }
        }
        if(set.size() != n) {
            r++;
        }
      }
      
      for(int i = 0; i<n;i++) {
        Set<Integer> set = new HashSet<>();
        for(int j=0;j<n;j++){
            set.add(matrix[j][i]);
        }
        if(set.size() != n) {
            c++;
        }
      }
      System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
    }
  }
}