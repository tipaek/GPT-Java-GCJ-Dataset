import java.util.*;
import java.io.*;

public class Solution {

    private static String solve(int ranks, int suits) {
        int[] deck = new int[ranks * suits];

        for (int suit = 0; suit < suits; suit++) {
            for (int rank = 0; rank < ranks; rank++) {
                int index = rank + suit * ranks;
                deck[index] = rank + 1;
            }
        }

        List<int[]> operations = new ArrayList<>();
        while (!isSorted(deck)) {
            int bEnd = -1;
            int aEnd = -1;
            int expectedRank = ranks;
            int rankCount = 0;

            for (int i = deck.length - 1; i >= 0; i--) {
                int value = deck[i];

                if (bEnd == -1 && value != expectedRank) {
                    bEnd = i;
                }

                if (bEnd == -1) {
                    rankCount++;
                    if (rankCount == suits) {
                        expectedRank--;
                        rankCount = 0;
                    }
                }

                if (bEnd != -1 && value == expectedRank) {
                    aEnd = i;
                    break;
                }
            }

            assert bEnd != -1;
            assert aEnd != -1;

            swapPiles(deck, aEnd, bEnd);

            int pileASize = aEnd + 1;
            int pileBSize = bEnd - aEnd;
            operations.add(new int[]{pileASize, pileBSize});
        }

        StringBuilder result = new StringBuilder();
        result.append(operations.size()).append("\n");
        for (int[] operation : operations) {
            result.append(operation[0]).append(" ").append(operation[1]).append("\n");
        }

        return result.toString().trim();
    }

    private static void swapPiles(int[] deck, int aEnd, int bEnd) {
        int pileASize = aEnd + 1;
        int pileBSize = bEnd - aEnd;

        int[] pileB = new int[pileBSize];
        for (int i = 0; i < pileBSize; i++) {
            pileB[i] = deck[aEnd + 1 + i];
        }

        for (int i = bEnd; i >= pileBSize; i--) {
            deck[i] = deck[i - pileBSize];
        }

        System.arraycopy(pileB, 0, deck, 0, pileBSize);
    }

    private static boolean isSorted(int[] deck) {
        for (int i = 1; i < deck.length; i++) {
            if (deck[i] < deck[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int ranks = scanner.nextInt();
            int suits = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(ranks, suits));
        }
    }
}