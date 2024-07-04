import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt(); // Number of test cases

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt(); // Number of pieces
            int D = scanner.nextInt(); // Desired number of pieces

            List<Long> anglesOfPieces = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                anglesOfPieces.add(scanner.nextLong());
            }

            Collections.sort(anglesOfPieces);

            long minCuts = D - 1;

            for (long angle : anglesOfPieces) {
                long cutsNeeded = 0;
                long piecesRemaining = D;
                long largerPiecesCount = 0;

                for (long piece : anglesOfPieces) {
                    if (angle == piece) {
                        piecesRemaining--;
                    } else if (piece > angle && piece % angle == 0) {
                        long multiples = piece / angle;
                        piecesRemaining -= multiples;
                        cutsNeeded += (multiples - 1);
                    } else if (piece > angle) {
                        largerPiecesCount++;
                    }
                    if (piecesRemaining <= 0) {
                        break;
                    }
                }

                if (piecesRemaining > 0) {
                    if (largerPiecesCount >= piecesRemaining) {
                        cutsNeeded += piecesRemaining;
                    } else {
                        cutsNeeded = D;
                    }
                }

                minCuts = Math.min(cutsNeeded, minCuts);
            }

            System.out.println("Case #" + testCase + ": " + minCuts);
        }
    }
}