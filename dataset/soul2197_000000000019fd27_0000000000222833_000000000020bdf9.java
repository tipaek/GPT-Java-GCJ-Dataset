import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int N = scanner.nextInt();
      final Time[] Ts = new Time[N];

      for (int i = 0; i < N; i++) {
        Ts[i] = new Time(scanner.nextInt(), scanner.nextInt(), i);
      }

      Arrays.sort(Ts);

      int[] overlap = new int[1440];
      boolean impossible = false;
      for (int i = 0; i < N && !impossible; i++) {
        for (int j = Ts[i].S; j < Ts[i].E && !impossible; j++) {
          overlap[j]++;
          if (overlap[j] > 2) {
            impossible = true;
          }
        }
      }

      if (impossible) {
        System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
      } else {
        final char[] result = new char[N];
        int cEnd = 0;
        for (int i = 0; i < N; i++) {
          if (Ts[i].S >= cEnd) {
            cEnd = Ts[i].E;
            result[Ts[i].index] = 'C';
          } else {
            result[Ts[i].index] = 'J';
          }
        }

        System.out.println(String.format("Case #%d: %s", t, new String(result)));
      }
    }
  }

  static class Time implements Comparable<Time> {
    int S;
    int E;
    int index;

    Time(int S, int E, int index) {
      this.S = S;
      this.E = E;
      this.index = index;
    }

    @Override
    public int compareTo(Time o) {
      if (S == o.S) {
        return E - o.E;
      }
      return S - o.S;
    }
  }
}
