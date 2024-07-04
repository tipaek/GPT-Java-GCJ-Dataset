import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int t=1;t<=testCases;t++) {
      int n = in.nextInt();
      int trace = 0;
      int repeatedColumnCount = 0;
      int repeatedRowCount = 0;
      List<Set<Integer>> columns = new ArrayList<>();
      List<Set<Integer>> rows = new ArrayList<>();
      for(int i=0;i<n;i++) {
        columns.add( new HashSet<>());
        rows.add(new HashSet<>());
      }
      for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
          int num = in.nextInt();
          rows.get(i).add(num);
          columns.get(j).add(num);
          if(i == j) {
            trace += num;
          }
        }
      }
      
      for(int i=0;i<n;i++) {
        if(rows.get(i).size()<n) {
          repeatedRowCount++;
        }
        if(columns.get(i).size() < n) {
          repeatedColumnCount++;
        }
      }
      
      System.out.println("Case #" + t +": "+trace+" "+ repeatedRowCount +" "+repeatedColumnCount);
    }
  }
}
