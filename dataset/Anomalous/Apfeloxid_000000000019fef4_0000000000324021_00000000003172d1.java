import java.util.*;

public class SolutionC {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();

            List<Long> angles = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                angles.add(scanner.nextLong());
            }

            Collections.sort(angles);

            long minCuts = D - 1;

            for (long angle : angles) {
                long cuts = 0;
                long piecesNeeded = D;
                long largerPiecesCount = 0;

                for (long comparisonAngle : angles) {
                    if (angle == comparisonAngle) {
                        piecesNeeded--;
                    } else if (comparisonAngle > angle && comparisonAngle % angle == 0) {
                        long multiple = comparisonAngle / angle;
                        long piecesCut = Math.min(piecesNeeded, multiple);
                        piecesNeeded -= multiple;
                        cuts += Math.min(piecesCut, multiple - 1);
                    } else if (comparisonAngle > angle) {
                        largerPiecesCount++;
                    }
                    if (piecesNeeded <= 0) {
                        break;
                    }
                }

                if (piecesNeeded > 0) {
                    if (largerPiecesCount >= piecesNeeded) {
                        cuts += piecesNeeded;
                    } else {
                        cuts = D;
                    }
                }

                minCuts = Math.min(cuts, minCuts);
            }

            System.out.println("Case #" + testCase + ": " + minCuts);
        }
    }
}