import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt();
      if (N == 2) {
        System.out.println("Case #" + t + ": JC");
        continue;
      }
      PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
      for (int i = 0; i < N; i++) {
        q.add(new int[] {sc.nextInt(), sc.nextInt(), i});
      }
      char[] sb = new char[N];
      int[] qJ = q.remove();
      sb[qJ[2]]= 'J';
      int[] qC = q.remove();
      sb[qC[2]]= 'C';
      boolean isPossible = true;
      while (!q.isEmpty()) {
        int[] se = q.poll();
        if (qJ[1] <= se[0]) {
          qJ = se;
          sb[qJ[2]]= 'J';
        } else if (qC[1] <= se[0]) {
          qC = se;
          sb[qC[2]]= 'C';
        } else {
          isPossible = false;
          System.out.println("Case #" + t + ": IMPOSSIBLE");
          break;
        }
      }
      if (isPossible) {
        System.out.println("Case #" + t + ": " + new String(sb));
      }
    }
  }
}
