import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      int [][] arr = new int[n][n];
      int trace = 0;
      int rows = 0;
      int cols = 0;
      for(int i = 0; i<n; i++) {
        for(int j = 0; j<n; j++) {
          int val = scan.nextInt();
          arr[i][j] = val;
          if(i==j) {
            trace += val;
          }
        }
      }
      for(int i = 0; i<n; i++) {
        Set<Integer> set = new HashSet<Integer>();
        for(int j = 0; j<n; j++) {
          set.add(arr[i][j]);
        }
        if(set.size() != n) {
          rows++;
        }
      }
      for(int i = 0; i<n; i++) {
        Set<Integer> set = new HashSet<Integer>();
        for(int j = 0; j<n; j++) {
          set.add(arr[j][i]);
        }
        if(set.size() != n) {
          cols++;
        }
      }
      System.out.println("Case #" + cases + ": " + trace + " " + rows + " " + cols);
      cases++;
    }
  }
}