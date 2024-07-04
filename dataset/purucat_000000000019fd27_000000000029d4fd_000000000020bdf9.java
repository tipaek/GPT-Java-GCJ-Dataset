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
      PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
      for (int i = 0; i < N; i++) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        q.add(new int[] {start, end, i});
      }
      char[] job = new char[N];
      int[] seJ = q.poll();
      job[seJ[2]] = 'J';
      int[] seC = q.poll();
      job[seC[2]] = 'C';
      boolean isPossible = true;
      while (!q.isEmpty()) {
        int[] se = q.poll();
        if (seJ[1] <= se[0]) {
          seJ = se;
          job[seJ[2]] = 'J';
        } else if (seC[1] <= se[0]) {
          seC = se;
          job[seC[2]] = 'C';
        } else {
          isPossible = false;
          System.out.println("Case #" + t + ": IMPOSSIBLE");
          break;
        }
      }
      if (isPossible) {
        System.out.println("Case #" + t + ": " + new String(job));
      }
    }
  }
}
