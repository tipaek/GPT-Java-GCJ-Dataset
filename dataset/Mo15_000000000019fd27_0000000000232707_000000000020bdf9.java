import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();

    for (int i = 0; i < tc; i++) {
      int N = sc.nextInt();
      Pair[] actv = new Pair[N];

      for (int j = 0; j < N; j++) {
        actv[j] = new Pair(sc.nextInt(), sc.nextInt(), j);
      }
      Arrays.sort(actv);
      char[] out = new char[N];
      boolean possible = select_tasks(N, actv, out);
      if (!possible) {
        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
      } else {
        System.out.print("Case #" + (i + 1) + ": ");
        for (int k = 0; k < N; k++) {
          System.out.print(out[k]);
        }
        System.out.println();
      }
    }
  }

  static boolean select_tasks(int N, Pair[] actv, char[] out) {
    out[actv[0].o_index] = 'J';
//    out[actv[1].o_index] = 'C';
//    if (N == 2) return true;

    int p_j = 0;
    int p_c = -1;

    for (int q = 1; q < N; q++) {
      if (actv[q].start >= actv[p_j].end) {
        out[actv[q].o_index] = 'J';
        p_j = q;
      } else if (p_c == -1) {
        out[actv[q].o_index] = 'C';
        p_c = q;
      }
    //   System.out.println(Arrays.toString(out));
    }

    if (p_c != -1) {
      for (int q = p_c + 1; q < N; q++) {
        if (actv[q].start >= actv[p_c].end && out[actv[q].o_index] != 'J') {
          out[actv[q].o_index] = 'C';
          p_c = q;
        } else if (out[actv[q].o_index] != 'J') {
        //   System.out.println("start: " + actv[q].start + " end: " + actv[p_c].end);
          return false;
        }
        // System.out.println(Arrays.toString(out));
      }
    }
    return true;
  }
}

class Pair implements Comparable<Pair> {
  int start;
  int end;
  int o_index;

  Pair(int start, int end, int o_index) {
    this.start = start;
    this.end = end;
    this.o_index = o_index;
  }

  public int compareTo(Pair o) {
    return this.end - o.end;
  }
}