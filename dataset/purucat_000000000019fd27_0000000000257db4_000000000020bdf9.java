import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      if (N == 2) {
        System.out.println("Case #" + t + ": JC");
        continue;
      }
      PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
      while (N-- > 0) {
        q.add(new int[] {sc.nextInt(), sc.nextInt()});
      }
      StringBuilder sb = new StringBuilder("JC");
      int[] qJ = q.remove();
      int[] qC = q.remove();
      boolean isPossible = true;
      while (!q.isEmpty()) {
        int[] se = q.poll();
        if (qJ[1] <= se[0]) {
          qJ = se;
          sb.append('J');
        } else if (qC[1] <= se[0]) {
          qC = se;
          sb.append('C');
        } else {
          isPossible = false;
          System.out.println("Case #" + t + ": IMPOSSIBLE");
          break;
        }
      }
      if (isPossible) {
        System.out.println("Case #" + t + ": " + sb.toString());
      }
    }
  }
}
