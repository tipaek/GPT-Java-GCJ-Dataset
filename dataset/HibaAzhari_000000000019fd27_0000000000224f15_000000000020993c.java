import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int s = 1; s <= t; ++s) {
      int N = in.nextInt();
      int trace = 0;
      List<HashSet<Integer>> record = new ArrayList<HashSet<Integer>>();
      for(int i = 0; i < N; i++){
          record.add(new HashSet<Integer>());
      }
      int r = 0, c = 0;
      Set<Integer> row = new HashSet<Integer>();
      boolean[] repC = new boolean[N];
      for(int i = 0; i < N; i++){
          boolean repR = false;
          row.clear();
          for(int j = 0; j < N; j++){
            int read = in.nextInt();
            if(record.get(j).contains(read)) repC[j] = true;
            if(row.contains(read)) repR = true;
            record.get(j).add(read);
            row.add(read);
            if(i == j) trace += read;
          }
          if(repR == true) r++;
      }
      for(boolean x:repC) if(x) c++;
      System.out.println("Case #" + s + ": " + trace + " " + r + " " + c);
    }
    in.close();
    System.exit(0);
    }
}