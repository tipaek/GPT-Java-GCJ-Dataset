import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int c = 1; c <= t; ++c) {
      int n = in.nextInt();
      Map<Integer, ArrayList<Integer>> rows = new HashMap<>();
      Map<Integer, ArrayList<Integer>> columns = new HashMap<>();
      Set<Integer> repeatedRows = new TreeSet<>();
      Set<Integer> repeatedColumns = new TreeSet<>();
      int k = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int val = in.nextInt();
          if (!rows.containsKey(i)) rows.put(i, new ArrayList<>());
          if (!columns.containsKey(j)) columns.put(j, new ArrayList<>());
          if (rows.get(i).contains(val)) repeatedRows.add(i);
          if (columns.get(j).contains(val)) repeatedColumns.add(j);
          if (i == j) k+=val;
          rows.get(i).add(val);
          columns.get(j).add(val);
        }
      }
      System.out.println("Case #" + c + ": " + k + " " + repeatedRows.size()+" " + repeatedColumns.size());
    }
  }
}