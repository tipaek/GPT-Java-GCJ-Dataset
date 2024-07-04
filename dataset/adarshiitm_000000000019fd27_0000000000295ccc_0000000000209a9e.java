package codejam.jam2020.qualification;

import java.util.Scanner;

public class Solution {

  enum Action {
    REVERSE,
    FLIP,
    BOTH,
    SAME
  }

  public static void solve(Scanner input, int B) {
    char[] arr = new char[B];
    int[] prev = new int[4];
    arr[0] = read(input, 0);
    arr[B - 1] = read(input, B - 1);
    prev[0] = arr[0];
    prev[3] = arr[B - 1];
    boolean foundSame = arr[0] == arr[B - 1];

    int leftMarker = -1;
    int rightMarker = -1;

    for (int i = 1; i < 5; i++) {
      arr[i] = read(input, i);
      arr[B - 1 - i] = read(input, B - 1 - i);
      if (leftMarker == -1 && foundSame == (arr[i] != arr[B - 1 - i])) {
        leftMarker = i;
        rightMarker = B - 1 - i;
        prev[1] = arr[i];
        prev[2] = arr[B - 1 - i];
      }
    }

    int left = 5;
    int right = B - 6;
    int read = 10;
    int query = 10;

    while (read < B) {
      Action action = getAction(input, leftMarker, rightMarker, prev, foundSame, B);
      query += 2;
      if (leftMarker != -1) {
        query += 2;
      }
      int limit = leftMarker == -1 ? 4 : 3;
      for (int i = 0; i < limit && read < B && query <= 150; i++) {
        arr[left + i] = read(input, left + i);
        arr[right - i] = read(input, right - i);
        if (leftMarker == -1 && foundSame == (arr[i] != arr[right - i])) {
          leftMarker = i;
          rightMarker = right - i;
        }
        read += 2;
      }
      applyAction(arr, action, left, B - 1);
      left += limit;
      right -= limit;
    }

    System.out.println(new String(arr));
    String result = input.next();
    if (result.equals("Y") || result.equals("N")) {
      return;
    }
  }

  private static void applyAction(char[] arr, Action action, int count, int right) {
    switch (action) {
      case REVERSE:
        reverse(arr, count, right);
        break;
      case FLIP:
        flip(arr, count, right);
        break;

      case BOTH:
        flip(arr, count, right);
        reverse(arr, count, right);
        break;
    }
  }

  private static void flip(char[] arr, int count, int right) {
    for (int i = 0; i < count; i++) {
      if (arr[i] == '0') {
        arr[i] = '1';
      } else {
        arr[i] = '0';
      }
      if (arr[right - i] == '0') {
        arr[right - i] = '1';
      } else {
        arr[right - i] = '0';
      }
    }
  }

  private static void reverse(char[] arr, int count, int right) {
    for (int i = 0; i < count; i++) {
      char t = arr[i];
      arr[i] = arr[right - i];
      arr[right - i] = t;
    }
  }

  private static Action getAction(Scanner input, int leftMarker, int rightMarker, int[] prev,
      boolean foundSame, int B) {
    int[] now = new int[4];
    now[0] = read(input, 0);
    now[3] = read(input, B - 1);
    Action action;

    if (leftMarker != -1) {
      now[1] = read(input, leftMarker);
      now[2] = read(input, rightMarker);
      action = compare(prev, now);
    } else {
      if (foundSame) {
        if (prev[0] == now[0] && prev[3] == now[3]) {
          action = Action.REVERSE;
        } else {
          return Action.FLIP;
        }
      } else {
        if (prev[0] == now[0] && prev[3] == now[3]) {
          action = Action.BOTH;
        } else {
          action = Action.REVERSE;
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      prev[i] = now[i];
    }
    return action;
  }

  private static Action compare(int[] prev, int[] now) {
    if (prev[0] == now[0] && prev[1] == now[1] && prev[2] == now[2] && prev[3] == now[3]) {
      return Action.SAME;
    } else if (prev[0] == now[3] && prev[1] == now[2] && prev[2] == now[1] && prev[3] == now[0]) {
      return Action.REVERSE;
    } else if (prev[0] + 1 % 2 == now[0] && prev[1] + 1 % 2 == now[1] && prev[2] + 1 % 2 == now[2]
        && prev[3] + 1 % 2 == now[3]) {
      return Action.FLIP;
    } else {
      return Action.BOTH;
    }
  }

  private static char read(Scanner input, int idx) {
    System.out.println(idx + 1);
    Integer i = input.nextInt();
    return i.toString().charAt(0);
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      solve(input, B);
    }
  }
}
