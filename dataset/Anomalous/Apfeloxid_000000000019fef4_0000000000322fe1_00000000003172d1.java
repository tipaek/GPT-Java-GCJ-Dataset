import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numPieces = SCANNER.nextInt();
            int desiredPieces = SCANNER.nextInt();

            List<Long> pieceAngles = new ArrayList<>();

            for (int i = 0; i < numPieces; i++) {
                pieceAngles.add(SCANNER.nextLong());
            }

            Collections.sort(pieceAngles);

            long minCuts = desiredPieces - 1;

            for (int i = 0; i < pieceAngles.size(); i++) {
                long currentAngle = pieceAngles.get(i);
                long cutsNeeded = 0;
                long remainingPieces = desiredPieces;
                long largerPiecesCount = 0;

                for (int j = i; j < pieceAngles.size(); j++) {
                    long angle = pieceAngles.get(j);
                    if (currentAngle == angle) {
                        remainingPieces--;
                    } else if (angle > currentAngle && angle % currentAngle == 0) {
                        long divisions = angle / currentAngle;
                        remainingPieces -= divisions;
                        cutsNeeded += (divisions - 1);
                    } else if (angle > currentAngle) {
                        largerPiecesCount++;
                    }
                    if (remainingPieces <= 0) {
                        break;
                    }
                }

                if (remainingPieces > 0 && largerPiecesCount >= remainingPieces) {
                    cutsNeeded += remainingPieces;
                } else if (remainingPieces > 0) {
                    cutsNeeded = desiredPieces;
                }

                minCuts = Math.min(cutsNeeded, minCuts);
            }

            System.out.println("Case #" + testCase + ": " + minCuts);
        }
    }
}