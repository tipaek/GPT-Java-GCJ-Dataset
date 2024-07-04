import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final int R = scanner.nextInt(); //2
      final int S = scanner.nextInt(); // 4

      int[] cards = new int[R * S];
      for (int r = 0; r < R; r++) {
        for (int s = 0; s < S; s++) {
          cards[r + s * R] = r + 1;
        }
      }

      final List<String> swaps = new ArrayList<>();
      while (true) {
        if (isSorted(cards)) break;

        int firstProblem = -1;
        for (int i = cards.length - 1; i > 0 && firstProblem == -1; i--) {
          if (cards[i-1] > cards[i]) {
            firstProblem = i - 1;
          }
        }

        int targetSpot = -1;
        for (int i = cards.length - 1; i > 0 && targetSpot == -1; i--) {
          if (cards[i] < cards[firstProblem]) {
            targetSpot = i;
          }
        }

        final int A = firstProblem + 1;
        final int B = targetSpot - firstProblem;
        swaps.add(A + " " + B);
        cards = swap(cards, A, B);
        int b = 3;
      }


      System.out.println(String.format("Case #%d: %d", t, cards.length));
      for (String swap : swaps) {
        System.out.println(swap);
      }
    }
  }

  static boolean isSorted(int[] cards) {
    for (int i = 1; i < cards.length; i++) {
      if (cards[i-1] > cards[i]) return false;
    }
    return true;
  }

  static int[] swap(int[] cards, int A, int B) {
    int[] newCards = new int[cards.length];
    for (int i = 0; i < B; i++) {
      newCards[i] = cards[A + i];
    }
    for (int i = 0; i < A; i++) {
      newCards[B + i] = cards[i];
    }
    for (int i = 0; i < cards.length - A - B; i++) {
      newCards[A + B + i] = cards[A + B + i];
    }
    return newCards;
  }
}
