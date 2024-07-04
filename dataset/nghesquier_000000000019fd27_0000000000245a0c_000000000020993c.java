import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


    //Number of tests
    int numberOfTests = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    //For each test case
    for (int k = 1; k <= numberOfTests; ++k) {
      int trace = 0;

      int c = 0;
      int r = 0;

      int n = in.nextInt();

      List<Set<Integer>> columns = new ArrayList<Set<Integer>>(n);
      List<Set<Integer>> lines = new ArrayList<Set<Integer>>(n);

      for (int i = 0; i < n; i++) {
        columns.add(i, new HashSet<>());
        lines.add(i, new HashSet<>());
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int intAtij = in.nextInt();
          if(i == j) {
            trace += intAtij;
          }

          lines.get(i).add(intAtij);
          columns.get(j).add(intAtij);
        }
      }

      for (int i = 0; i < n; i++) {
        if(lines.get(i).size() < n) {
          r++;
        }
        if(columns.get(i).size() < n) {
          c++;
        }
      }

      System.out.println("Case #" + k + ": " + trace + " " + r + " " + c);
    }
  }
}
