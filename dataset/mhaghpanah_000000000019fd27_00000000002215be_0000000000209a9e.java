
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

  static int count = 0;

  public static int r(Scanner input, int index) {
    System.out.println(index);
    count++;
    return input.nextInt();
  }

  public static void f(Scanner input) {
    while (count % 10 != 0) {
      r(input, 1);
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int b = input.nextInt();
    for (int c = 0; c < t; c++) {
      int[] state = new int[b + 1];
      count = 0;
      int s = -1;
      int d = -1;
      List<Integer> same = new ArrayList<>();
      List<Integer> diff = new ArrayList<>();
      for (int i = 1; i <= b / 2; ) {
        for (int j = 0; j < 4 && i <= b / 2; j++, i++) {
          state[i] = r(input, i);
          state[b + 1 - i] = r(input, b + 1 - i);
          if (s == -1 && state[i] == state[b + 1 - i]) s = i;
          if (d == -1 && state[i] != state[b + 1 - i]) d = i;
        }

        if (s == -1) {
          same.add(s);
          r(input, 1);
        } else {
          same.add(r(input, s));
        }

        if (d == -1) {
          diff.add(d);
          r(input, 1);
        } else {
          diff.add(r(input, d));
        }

      }

      f(input);
//      System.out.println("-----------------");

      int sv = 0;
      int dv = 0;

      if (s != -1) {
        sv = r(input, s);
      }

      if (d != -1) {
        dv = r(input, d);
      }

      if (b % 2 == 1) {
        state[b / 2 + 1] = r(input, b / 2 + 1);
      }

      for (int i = 1, q = 0; i <= b / 2; q++) {
        for (int j = 0; j < 4 && i <= b / 2; j++, i++) {
          if (state[i] == state[b + 1 - i]) {
            state[i] = state[i] ^ same.get(q) ^ sv;
            state[b + 1 - i] = state[b + 1 - i] ^ same.get(q) ^ sv;
          } else {
            state[i] = state[i] ^ diff.get(q) ^ dv;
            state[b + 1 - i] = state[b + 1 - i] ^ diff.get(q) ^ dv;
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= b; i++) sb.append(state[i]);
      System.out.println(sb.toString());
      input.nextLine();
      String str = input.nextLine();
      if (!str.equals("Y")) return;

    }
  }
}
