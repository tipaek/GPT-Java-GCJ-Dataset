import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      
      String path = getPath(n, m);
      
      System.out.println("Case #" + i + ": " + path);
    }
  }
  
  private static String getPath(int x, int y){
      if(!isPossible(x, y)){
          return "IMPOSSIBLE";
      }
      
      return dfs(0, 0, x, y, 1, new ArrayDeque<>());
  }
  
  private static boolean isPossible(int x, int y){
      return (Math.abs(x) + Math.abs(y) - 1) % 2 == 0;
  }
  
  private static String dfs(int curx, int cury, 
  int goalx, int goaly,
  int jump, Deque<String> path){
      if(curx == goalx && cury == goaly){
          StringBuilder sb = new StringBuilder(path.size());
          for(int i = path.size() - 1; i >= 0; i--){
              sb.append(path.removeLast());
          }
          
          return sb.toString();
      }
      else if(jump > Math.abs(goalx) + Math.abs(goaly)){
          return null;
      }
      
      String res;
      
      //jump north
      path.push("N");
      res = dfs(curx, cury + jump, goalx, goaly, jump * 2, path);
      if(res != null) return res;
      path.pop();
      
      //jump south
      path.push("S");
      res = dfs(curx, cury - jump, goalx, goaly, jump * 2, path);
      if(res != null) return res;
      path.pop();
      
      //jump east
      path.push("E");
      res = dfs(curx + jump, cury, goalx, goaly, jump * 2, path);
      if(res != null) return res;
      path.pop();
      
      //jump west
      path.push("W");
      res = dfs(curx - jump, cury, goalx, goaly, jump * 2, path);
      if(res != null) return res;
      path.pop();
      
      return null;
  }
} 