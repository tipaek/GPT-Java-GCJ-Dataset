import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author himanshugupta - created on 04/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tt = t;
    while (t-- != 0) {
      int n = sc.nextInt();
      int mat[][] = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      long trace = 0;
      int rr=0,cr=0;
      for (int i = 0; i < n; i++) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
          set.add(mat[i][j]);
          if(i==j){
            trace+=mat[i][j];
          }
        }
        if (set.size() != n) {
          rr++;
        }
      }
      for(int j=0;j<n;j++){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
          set.add(mat[i][j]);
        }
        if (set.size() != n){
          cr++;
        }
      }
      System.out.println("Case #" + (tt - t + ": " + trace + " " + rr + " " + cr));
    }
  }
}
