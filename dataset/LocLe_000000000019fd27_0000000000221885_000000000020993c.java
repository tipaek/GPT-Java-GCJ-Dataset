import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt(); 
    for (int i = 1; i <= numTests; i++) {
      int N = in.nextInt();
      int trace = 0;
      int wrongCol = 0;
      int wrongRow = 0;
      List<Set<Integer>> colSet = new ArrayList<>();
      List<Boolean> wrongColCnt = new ArrayList<>();
      
      for (int m = 0; m < N; m++) {
          colSet.add(new HashSet());
          wrongColCnt.add(false);
      }
      for (int j = 0; j < N; j++) {
          Set<Integer> rowSet = new HashSet();
          boolean rowDuplicated = false;
          for (int k = 0; k < N; k++) {
              int num = in.nextInt();
              if (k == j) {
                  trace += num;
              }
              if (rowSet.contains(num)) {
                  rowDuplicated = true;
              } else {
                  rowSet.add(num);
              }
              if (colSet.get(k).contains(num)) {
                  wrongColCnt.set(k, true);
              } else {
                  colSet.get(k).add(num);
              }
          }
          if (rowDuplicated) {
              wrongRow++;
          }
      }
      for (Boolean col: wrongColCnt) {
          if (col) {
              wrongCol++;
          }
      }
      System.out.println("Case #" + i + ": " + trace + " " + wrongRow + " " + wrongCol);
    }
  }
}