import java.util.*;
import java.io.*;
public class Solution {
  public static boolean bad(int x, int y, int[][] s, boolean[][] v) {
      int cnt = 0;
      int sum = 0;
      for(int i = x - 1; i >= 0; --i) {
          if(v[i][y]) {
              ++cnt;
              sum += s[i][y];
              break;
          }
      }
      for(int i = x + 1; i < s.length; ++i) {
          if(v[i][y]) {
              ++cnt;
              sum += s[i][y];
              break;
          }
      }
      for(int j = y - 1; j >= 0; --j) {
          if(v[x][j]) {
              ++cnt;
              sum += s[x][j];
              break;
          }
      }
      for(int j = y + 1; j < s[0].length ; ++j) {
          if(v[x][j]) {
              ++cnt;
              sum += s[x][j];
              break;
          }
      }
      return !(cnt == 0 || cnt * s[x][y] >= sum);
  }    
    
  public static void solve(Scanner in, int index) {
    int r = in.nextInt();
    int c = in.nextInt();
    int[][] s = new int[r][c];
    boolean[][] v = new boolean[r][c];
    long ans = 0;
    int sum = 0;
    for(int i = 0; i < r; ++i) {
        for(int j = 0; j < c; ++j) {
            s[i][j] = in.nextInt();
            v[i][j] = true;
            sum += s[i][j];
        }
    }
    while(true) {
        ans += sum;
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                if(v[i][j] && bad(i, j, s, v)) {
                    x.add(i);
                    y.add(j);
                    sum -= s[i][j];
                }
            }
        }
        for(int i = 0; i < x.size(); ++i) {
          v[x.get(i)][y.get(i)] = false;
        }
        if(x.size() == 0) break;
    }
    System.out.println("Case #" + index + ": " + ans);
  }    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      solve(in, i);
    }
  }
}