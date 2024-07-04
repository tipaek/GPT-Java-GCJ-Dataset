import java.io.*;
import java.util.*;

public class Solution {
  private static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int T = sc.nextInt();
    int B = sc.nextInt();
    for (int qw = 1; qw <= T; qw++) {
      int[] bits = new int[B];
      int oppositeSame = -1;
      int oppositeDifferent = -1;
      for (int i = 0; i < bits.length; i++) bits[i] = -1;
      while (true) {
        if (oppositeSame == oppositeDifferent) {
          // Just starting.
          Query(0);
          Query(0);
        } else if (oppositeSame == -1) {
          // No difference between reversing and inverting.
          Query(0);
          int x = Query(oppositeDifferent);
          if (x != bits[oppositeDifferent]) {
            invert(bits);
          }
        } else if (oppositeDifferent == -1) {
          // Reversing does nothing.
          Query(0);
          int x = Query(oppositeSame);
          if (x != bits[oppositeSame]) {
            invert(bits);
          }
        } else {
          boolean inverted = Query(oppositeSame) != bits[oppositeSame];
          boolean reversedXorInverted = Query(oppositeDifferent) != bits[oppositeDifferent];
          if (inverted) invert(bits);
          if (reversedXorInverted ^ inverted) reverse(bits);
        }
        int left = 8;
        for (int i = 0; i < B; i++) {
          if (bits[i] == -1) {
            bits[i] = Query(i);
            bits[B - 1 - i] = Query(B - 1 - i);
            left -= 2;
            if (left == 0) break;
          }
        }
        boolean done = true;
        for (int i = 0; i < B; i++) if (bits[i] == -1) done = false;
        if (done) break;
        for (int i = 0; i < B/2; i++) {
          if (bits[i] == -1) continue;
          if (bits[i] != bits[B-i-1]) oppositeDifferent = i;
          if (bits[i] == bits[B-i-1]) oppositeSame = i;
        }
      }
      for (int i = 0; i < B; i++) {
        System.out.print(bits[i]);
      }
      System.out.println();
      String judgeAnswer = sc.next();
      if (judgeAnswer.equals("N")) return;
    }
  }

  private static void invert(int[] b) {
    for (int i = 0; i < b.length; i++) {
      if (b[i] >= 0) b[i] = 1 - b[i];
    }
  }

  private static void reverse(int[] b) {
    for (int i = 0; i < b.length / 2; i++) {
      int temp = b[i];
      b[i] = b[b.length - i - 1];
      b[b.length - i - 1] = temp;
    }
  }

  private static int Query(int n) {
    System.out.println(n + 1);
    System.out.flush();
    return sc.nextInt();
  }
}
