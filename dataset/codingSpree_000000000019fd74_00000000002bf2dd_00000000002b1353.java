import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    ArrayList<ArrayList<Integer>> pascalTriangle = buildPascalTriangle();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        ArrayList<Integer> path = getPathForPascalWalkMain(n, pascalTriangle);
        System.out.println("Case #" + i + ": ");
        for (int j =0; j < path.size(); j++) {
            int row = path.get(j)/100 + 1;
            int col = path.get(j)%100 + 1;
            System.out.println(row + " " + col);
        }
    }
  }
  
  public static ArrayList<Integer> getPathForPascalWalkMain(int n, 
                    ArrayList<ArrayList<Integer>> pascalTriangle) {
    HashSet<Integer> seen = new HashSet<Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(0);seen.add(0);
    getPathForPascalWalk(n-1, pascalTriangle, result, seen);
    return result;
  }
  public static final int[][] dir = {{-1,-1}, {-1, 0}, {0,-1},
                                     {0,1}, {1,0}, {1,1}};
                                     
  public static boolean getPathForPascalWalk(int n, 
            ArrayList<ArrayList<Integer>> pascalTriangle, 
            ArrayList<Integer> result,
            HashSet<Integer> seen) {
      if (n == 0) {
          return true ;
      }
      if (result.size() >= 500) {
          return false;
      }
      int currRow = result.get(result.size()-1)/100;
      int currCol = result.get(result.size()-1)%100;
      
      for (int i = 0; i < dir.length; i++) {
          int newRow = currRow + dir[i][0];
          int newCol = currCol + dir[i][1];
          if (newRow >= 0 && newRow < 31 && newCol >= 0 && newCol <= newRow) {
              if ( n >= pascalTriangle.get(newRow).get(newCol) ) {
                  int currHash = newRow*100 + newCol;
                  if (!seen.contains(currHash)) {
                      result.add(currHash);
                      seen.add(currHash);
                      if (getPathForPascalWalk(n-pascalTriangle.get(newRow).get(newCol),
                          pascalTriangle, result, seen)) {
                            //   System.out.println(n + " " + newRow + " " + newCol);
                              return true;
                          }
                        //   System.out.println(n + " " + newRow + " " + newCol + " REMOVED");
                      result.remove(result.size()-1);
                      seen.remove(currHash);
                  }
              }
          }
      }
      
      return false;
  }
  
  public static ArrayList<ArrayList<Integer>> buildPascalTriangle() {
      ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>(31);
      ArrayList<Integer> rowOne = new ArrayList<Integer>();
      rowOne.add(1);
      pascalTriangle.add(rowOne);
      for (int i = 1; i < 31; i++) {
          ArrayList<Integer> currRow = new ArrayList<Integer>(i+1);
          currRow.add(1);
          for (int j = 1; j < i; j++) {
              currRow.add(pascalTriangle.get(i-1).get(j-1) + 
                          pascalTriangle.get(i-1).get(j));
          }
          currRow.add(1);
          pascalTriangle.add(currRow);
      }
      return pascalTriangle;
  }
}