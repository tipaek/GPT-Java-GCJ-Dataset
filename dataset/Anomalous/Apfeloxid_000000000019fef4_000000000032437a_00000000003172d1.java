import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numPieces = scanner.nextInt();
            int desiredPieces = scanner.nextInt();

            List<Long> pieceAngles = new ArrayList<>();

            for (int i = 0; i < numPieces; i++) {
                pieceAngles.add(scanner.nextLong());
            }

            Collections.sort(pieceAngles);

            long minimumCuts = desiredPieces - 1;

            for (Long baseAngle : pieceAngles) {
                long cutsRequired = 0;
                long piecesNeeded = desiredPieces;
                long largerPiecesCount = 0;

                for (Long comparisonAngle : pieceAngles) {
                    if (baseAngle.equals(comparisonAngle)) {
                        piecesNeeded--;
                    } else if (comparisonAngle > baseAngle && comparisonAngle % baseAngle == 0) {
                        long multiple = comparisonAngle / baseAngle;
                        long piecesFromCut = Math.min(piecesNeeded, multiple);
                        piecesNeeded -= piecesFromCut;
                        cutsRequired += Math.min(piecesFromCut, multiple - 1);
                    } else if (comparisonAngle > baseAngle) {
                        largerPiecesCount++;
                    }
                    if (piecesNeeded <= 0) {
                        break;
                    }
                }

                if (piecesNeeded > 0) {
                    if (largerPiecesCount >= piecesNeeded) {
                        cutsRequired += piecesNeeded;
                    } else {
                        cutsRequired = desiredPieces;
                    }
                }

                minimumCuts = Math.min(cutsRequired, minimumCuts);
            }

            System.out.println("Case #" + testCase + ": " + minimumCuts);
        }
    }
}