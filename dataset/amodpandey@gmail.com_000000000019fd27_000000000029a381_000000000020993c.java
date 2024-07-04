import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int testCases = sc.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = sc.nextInt();
      int k = 0, r = 0, c = 0;

      HashMap<Integer, HashSet<Integer>> rh = new HashMap<Integer, HashSet<Integer>>();
      HashMap<Integer, HashSet<Integer>> ch = new HashMap<Integer, HashSet<Integer>>();
      
      for (int p = 0; p < n  * n; p++) {
        int i = p/n;
        int j = p%n;
        int val = sc.nextInt();
        if (i == j) k += val;
        
        HashSet<Integer> rhi = rh.getOrDefault(i, new HashSet<Integer>());
        rhi.add(val);
        rh.put(i, rhi);
        
        HashSet<Integer> chi = ch.getOrDefault(j, new HashSet<Integer>());
        chi.add(val);
        ch.put(j, chi);
      }
      
      for (HashSet<Integer> x : rh.values()) {
        if(x.size() != n) r++;
      }

      for (HashSet<Integer> x : ch.values()) {
        if(x.size() != n) c++;
      }

      pw.printf("Case #" + testCase + ": %d %d %d\n", k, r, c);
      pw.flush();
    }
    pw.close();
    sc.close();
  }
}
