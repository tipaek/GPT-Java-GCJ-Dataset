import java.io.*;
import java.util.*;

public class Solution {
  static int T, B;
  static StringBuffer solution;
  static Scanner sc;

  static int anchorFlip, anchorReverse;
  static char guessComp;
  static int guessCount;

  public static void main(String[] args) {
    sc = new Scanner(System.in);

    T = sc.nextInt();
    B = sc.nextInt();
    if (sc.hasNextLine()) {
      sc.nextLine();
    }

    for (int run = 1; run <= T; run++) {
      setup();
      run();
      solve();
    }
  }

  public static void setup() {
    solution = new StringBuffer();
    for (int i = 0; i < B; i++) {
      solution.append("-");
    }

    anchorFlip = -1;
    anchorReverse = -1;
    guessComp = 0;

    guessCount = 0;
  }

  public static void run() {
    int currInd = 1;
    while (guessCount < 150) {
      if (guessCount > 0 && guessCount % 10 == 0) {
        handleQuantumFluctuations();
      }

      int nextInd = query(currInd);

      if (nextInd == currInd) {
        return;
      }
      currInd = nextInd;
    }
  }

  public static int query(int ind) {
    // i/o
    System.out.println(ind);
    guessCount++;
    char res = sc.nextLine().trim().charAt(0);

    // set anchors
    solution.setCharAt(ind - 1, res);
    if (guessComp == 0) {
      guessComp = res;
    } else if (anchorFlip == -1 && guessComp == res) {
      anchorFlip = ind;
      guessComp = 0;
    } else if (anchorReverse == -1 && guessComp != res) {
      anchorReverse = ind;
      guessComp = 0;
    }
    // debug
    // System.out.println(solution);
    // System.out.printf("%s %s %s\n", anchorFlip, anchorReverse, guessCount);

    // next guess
    if (ind > B / 2) {
      return B - ind + 2;
    } else {
      return B - ind + 1;
    }
  }

  public static void handleQuantumFluctuations() {
    boolean flipped = false;
    boolean reversed = false;

    if (anchorFlip > 0) {
      System.out.println(anchorFlip);
      guessCount++;
      char res = sc.nextLine().trim().charAt(0);

      flipped = (res != solution.charAt(anchorFlip - 1));
    }

    if (anchorReverse > 0) {
      System.out.println(anchorReverse);
      guessCount++;
      char res = sc.nextLine().trim().charAt(0);

      reversed = (res != solution.charAt(anchorReverse - 1));
      if (flipped) {
        reversed = !reversed;
      }
    }

    if (reversed) {
      solution = solution.reverse();
    }
    if (flipped) {
      for (int i = 0; i < B; i++) {
        switch (solution.charAt(i)) {
          case '0':
            solution.setCharAt(i, '1');
            break;
          case '1':
            solution.setCharAt(i, '0');
            break;
        }
      }
    }
  }

  public static void solve() {
    System.out.println(solution);
    char res = sc.nextLine().trim().charAt(0);
    if ('Y' == res) {
      // TODO: celebrate
    } else {
      // TODO: cry deeply
    }
  }
}