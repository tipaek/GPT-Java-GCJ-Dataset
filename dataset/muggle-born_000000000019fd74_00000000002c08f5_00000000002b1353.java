import java.util.*;
import java.io.*;

public class Solution {

  static int[] dx = {-1,-1,0,0,1,1};
  static int[] dy = {-1,0,-1,1,0,1};


  private static List<List<Integer>> generatePascalTriangle(int n) {
    List<List<Integer>> pscTriangle = new ArrayList<List<Integer>>();
    for (int line = 1; line <= n; line++) {
      List<Integer> pscLine = new ArrayList<Integer>();
      int c = 1;
      for (int i = 1; i <= line; i++) {
        pscLine.add(c);
        c = c * (line-i)/i;
      }
      pscTriangle.add(pscLine);
    }

    return pscTriangle;
  }

  private static void printPath(List<int[]> path) {
    for (int[] xy : path) {
      System.out.println(String.format("%d %d", xy[0]+1, xy[1]+1));
    }
  }

  private static boolean dfs(List<List<Integer>> pscTriangle, int target, List<int[]> path, int i, int j, int sum) {
    if (sum > target) {
      return false;
    }

    // mark as visited & add to set
    int tmp = pscTriangle.get(i).get(j);
    pscTriangle.get(i).set(j, -1);
    path.add(new int[]{i,j}); 

    if (sum == target) {
      printPath(path);
      return true;
    }

    for (int k = 0; k < 6; k++) {
      int rr = i + dx[k];
      int cc = j + dy[k];
      if (isWithin(pscTriangle, rr, cc) && pscTriangle.get(rr).get(cc) != -1) {
        // System.out.println(String.format("(%d,%d)", rr, cc));
        if (dfs(pscTriangle, target, path, rr, cc, sum + pscTriangle.get(rr).get(cc))) {
          return true;
        }
      }

    }
    
    // mark as not visited & remove set
    pscTriangle.get(i).set(j, tmp);
    path.remove(path.size()-1);

    return false;
  }

  private static boolean isWithin(List<List<Integer>> pscTriangle, int i, int j) {
    if (i < 0 || j < 0 || i >= pscTriangle.size() || j >= pscTriangle.get(i).size()) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    // List<List<Integer>> pscTriangle = generatePascalTriangle(50);
    for (int i = 1; i <= t; ++i) {
      int target = in.nextInt();
      List<List<Integer>> pscTriangle = generatePascalTriangle(50);
      List<int[]> path = new ArrayList<>();

      System.out.println(String.format("Case %d:", i));
      dfs(pscTriangle, target, path, 0, 0, 1);
    }
  }
} 