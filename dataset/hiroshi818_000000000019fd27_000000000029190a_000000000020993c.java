import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    int row = 0;
    int col = 0;
    int trace = 0;
    Set<Integer> hash_Set = new HashSet<Integer>(); 
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 1; i <= t; ++i) {
      int size = in.nextInt();
      for (int j = 1; j <= size; j++) {
        for (int k = 1; k <= size; k++) {
          int n = in.nextInt();
          if (i == j) trace += n;
          if (!hash_Set.add(n)) row++;
          if (!set.add(10*j+n)) col++;
        }
        hash_Set.clear();
      }
      System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
    }
  }
}