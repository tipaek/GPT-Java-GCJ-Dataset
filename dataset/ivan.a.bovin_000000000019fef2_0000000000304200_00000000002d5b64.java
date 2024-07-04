import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        for (long t = 1; t <= T; ++t) {
            final int R = input.nextInt();
            final int S = input.nextInt();
            final int[] cards = new int[R * S];
            for (int s = 0; s < S; ++s) {
                for (int r = 0; r < R; ++r) {
                    cards[s * R + r] = r;
                }
            }

            List<String> solution = new ArrayList<>();

            for (int r = R - 1; r > 0; --r) {
                for (int s = S - 1; s > 0; --s) {
                    int last = -1;
                    for (int i = S * R - 1; i >= 0; i--) {
                        if (cards[i] == r) {
                            last = i;
                        }

                        if (last >= 0 && cards[i] != r) {
                            break;
                        }
                    }
                    int penultimate = -1;
                    for (int i = last - 1; i >= 0; i--) {
                        if (cards[i] == r) {
                            penultimate = i;
                            break;
                        }
                    }
                    int a = penultimate + 1;
                    int b = last - penultimate - 1;
                    solution.add(a + " " + b);
                    move(cards, penultimate, last);
                }
            }

            System.out.format("Case #%d: %d\n", t, solution.size());
            solution.forEach(System.out::println);
        }
    }

    private static void move(int[] cards, int a, int b) {
        int[] tmp = Arrays.copyOf(cards, cards.length);
        for (int i = 0; i <= a; i++) {
            cards[b - a + i - 1] = tmp[i];
        }
        for (int i = a + 1; i < b; i++) {
            cards[i - a - 1] = tmp[i];
        }
    }
}