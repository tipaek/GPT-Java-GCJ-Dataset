import java.util.*;
public class Solution { 
  public static void main(String[] args)             {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int qq = 1; qq < N+1; qq++){
      int n = sc.nextInt();
      int k = 0, r = 0, c = 0; 
      boolean[] row = new boolean[n], col = new boolean[n];
      boolean[][][] arr = new boolean[2][n][n+1];
      for(int i = 0; i < n; i++) { 
        for(int j = 0; j < n; j++) {
          int m = sc.nextInt(); 
          if(i == j)
            k += m;
          if(!row[i] && arr[0][i][m]) {
            row[i] = true;
            r++;
          }
          else arr[0][i][m] = true;
          if(!col[j] && arr[1][j][m]) {
            col[j] = true;
            c++;
          }
          else arr[1][j][m] = true;
        }
      }
      System.out.println("Case #"+qq+": "+k+" "+r+" "+c);
    }
  }
}