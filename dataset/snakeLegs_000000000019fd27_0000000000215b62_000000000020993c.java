import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int n = sc.nextInt();

      int rows[] = new int[n];
      int cols[] = new int[n];
      int trace = 0;

      HashMap<Integer, List<Integer>> rowm = new HashMap<>();
      HashMap<Integer, List<Integer>> colm = new HashMap<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int val = sc.nextInt();

          if (i == j) {
            trace += val;
          }

          if (rowm.containsKey(i)) {
            List<Integer> rints = rowm.get(i);
            if (rints.contains(val)) {
              rows[i]++;
            }
            rints.add(val);
            rowm.put(i, rints);
          } else {
            List<Integer> rints = new ArrayList<>();
            rints.add(val);
            rowm.put(i, rints);
          }

          if (colm.containsKey(j)) {
            List<Integer> cints = colm.get(j);
            if (cints.contains(val)) {
              cols[j]++;
            }
            cints.add(val);
            colm.put(j, cints);
          } else {
            List<Integer> cints = new ArrayList<>();
            cints.add(val);
            colm.put(j, cints);
          }
        }
      }

      int ar = 0;
      int cr = 0;

      for (int i = 0; i < n; i++) {
        if (rows[i] != 0) {
          ar++;
        }

        if (cols[i] != 0) {
          cr++;
        }
      }

      System.out.println("Case #" + tcn + ": " + trace + " " + ar + " " + cr);
      tcn++;
    }
  }
}
