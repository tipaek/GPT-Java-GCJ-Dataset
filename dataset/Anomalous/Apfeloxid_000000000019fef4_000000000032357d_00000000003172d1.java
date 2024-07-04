import java.util.*;

public class SolutionC {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numPieces = scanner.nextInt();
            int desiredPieces = scanner.nextInt();

            List<Long> angles = new ArrayList<>();
            for (int i = 0; i < numPieces; i++) {
                angles.add(scanner.nextLong());
            }

            Collections.sort(angles);

            long minCuts = desiredPieces - 1;

            for (long angle : angles) {
                long cuts = 0;
                long piecesNeeded = desiredPieces;
                long largerPiecesCount = 0;

                for (long currentAngle : angles) {
                    if (currentAngle == angle) {
                        piecesNeeded--;
                    } else if (currentAngle > angle && currentAngle % angle == 0) {
                        long ratio = currentAngle / angle;
                        piecesNeeded -= ratio;
                        cuts += (ratio - 1);
                    } else if (currentAngle > angle) {
                        largerPiecesCount++;
                    }
                    if (piecesNeeded <= 0) {
                        break;
                    }
                }

                if (piecesNeeded > 0 && largerPiecesCount >= piecesNeeded) {
                    cuts += piecesNeeded;
                } else if (piecesNeeded > 0) {
                    cuts = desiredPieces;
                }

                minCuts = Math.min(cuts, minCuts);
            }

            System.out.println("Case #" + testCase + ": " + minCuts);
        }
    }
}