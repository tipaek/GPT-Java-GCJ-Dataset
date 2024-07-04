import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        long[] values = new long[N];
        Set<Long> possibleSizes = new HashSet<>();

        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextLong() * D;
            possibleSizes.add(values[i]);
            possibleSizes.add(values[i] / D);
        }

        Arrays.sort(values);

        long minCuts = D - 1;
        for (long targetSize : possibleSizes) {
            long slices = 0;
            long cuts = 0;
            List<Long> goodPieces = new ArrayList<>();
            List<Long> badPieces = new ArrayList<>();

            for (long value : values) {
                if (value >= targetSize && value % targetSize == 0) {
                    goodPieces.add(value);
                } else {
                    badPieces.add(value);
                }
            }

            boolean success = false;
            for (long goodPiece : goodPieces) {
                slices += goodPiece / targetSize;
                cuts += goodPiece / targetSize;
                if (slices == D || slices == D + 1) {
                    cuts--;
                    success = true;
                    break;
                }
                if (slices > D) {
                    cuts -= (slices - D);
                    success = true;
                    break;
                }
                cuts--;
            }

            if (!success) {
                for (long badPiece : badPieces) {
                    slices += badPiece / targetSize;
                    cuts += badPiece / targetSize;
                    if (slices >= D) {
                        cuts -= (slices - D);
                        success = true;
                        break;
                    }
                }
            }

            if (success) {
                minCuts = Math.min(minCuts, cuts);
            }
        }

        System.out.println(minCuts);
    }
}