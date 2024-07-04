import java.io.*;
import java.util.*;

class Solution { 
    static int l[][] = new int[100][100];
    static int dp[][] = new int[100][100];
  
    static void initialize() 
    { 
      l[0][0] = 1; 
      dp[0][0] = 1;
      for (int i = 1; i < 100; i++) { 
        l[i][0] = 1; 
        dp[i][0] = dp[i-1][0] + l[i][0];
        for (int j = 1; j < i + 1; j++) { 
          l[i][j] = (l[i - 1][j - 1] + l[i - 1][j]); 
          if (j > (i - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + l[i][j];
          } else {
            int opt1 = dp[i-1][j];
            int opt2 = dp[i-1][j];
            if (opt1 > opt2) {
              dp[i][j] = dp[i - 1][j - 1] + l[i][j];
            } else {
              dp[i][j] = dp[i - 1][j] + l[i][j];
            }
          }
        } 
      } 
    }
    
    public static void main(String[] args) 
    { 
        initialize(); 

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int i = 0; i < tc; i++) {
            LinkedList<int[]> path =  new LinkedList<int[]>();
            
            int target = sc.nextInt();
            if (target == 1) {
                path.add(new int[]{0, 0});
            } else {
                int r = 0;
                int c = 0;
                
                boolean breaker = false;
                for (r = 1; r < 100; r++) { 
                  for (c = 1; c < r + 1; c++) { 
                      if (dp[r][c] == target) {
                          breaker = true;
                          // System.out.println("broken");
                          break;
                      }
                  }
                  if (breaker) break;
                }
                
                if (!breaker) {
                  path.add(new int[]{0,0});
                } else {
                  path.add(new int[]{r, c});
                  while (r != 0) {
                    // System.out.println(r + " " + c);
                    if (c - 1 < 0) {
                      r = r - 1;
                    } else if (c > (r - 1)) {
                      r = r - 1;
                      c = c - 1;
                    } else {
                      int opt1 = dp[r-1][c];
                      int opt2 = dp[r-1][c];
                      if (opt1 < opt2) {
                        r = r - 1;
                        c = c - 1;
                      } else {
                        r = r - 1;
                      }
                    }
                    path.add(new int[]{r, c});
                  }
                }
                
              }
            System.out.println("Case #" + i + ":");
            // System.out.println(path.size());
            for (int a = path.size() - 1; a >= 0; a--) {
                System.out.println((1 + path.get(a)[0]) + " " + (1 + path.get(a)[1]));
            }
            
            


        }
    } 
}