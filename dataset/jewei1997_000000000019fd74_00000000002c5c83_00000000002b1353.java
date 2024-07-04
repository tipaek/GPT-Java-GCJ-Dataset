import java.util.*;

public class Solution {

  static int power(int x) {
    int pow = 0;
    while ((1 << pow) < x) pow++;
    return pow-1;
  }

  static void algo(List<Integer> x, List<Integer> y, int N) {
    x.add(0); y.add(0);
    N--;
    while (true) {
      if (N == 0) return;
      if (N < 10) {
        for (int i = 1; i <= N; i++) {
          x.add(i); y.add(0);
        }
        return;
      }
      int p = power(N);
      int sp = p - 2;
      // go down
      for (int i = 1; i < sp; i++) { x.add(i); y.add(0); }
      // iterate over row sp forward
      for (int i = 0; i <= sp; i++) { x.add(sp); y.add(i); }
      // iterate over row sp backwards
      for (int i = sp-1; i >= 0; i--) { x.add(sp); y.add(i); }
      // go back up
      for (int i = sp - 1; i >= 0; i--) { x.add(i); y.add(0); }

      N -= (sp-1) + (1<<sp) + (1<<sp)-1 + (sp-1) + 1;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 0; t < T; t++) {
      int input = sc.nextInt();
      List<Integer> x = new ArrayList<>();
      List<Integer> y = new ArrayList<>();
      algo(x, y, input);
      System.out.println("Case #" + (t+1) + ": ");
      for (int i = 0; i < x.size(); i++) {
        System.out.printf("%d %d", x.get(i)+1, y.get(i)+1);
        if (i != x.size() - 1) System.out.println();
      }
      if (t != T-1) System.out.print("\n");
    }
  }
}