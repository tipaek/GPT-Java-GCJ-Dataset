import java.util.*;

public class Solution {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();

            List<Long> anglesOfPieces = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                anglesOfPieces.add(scanner.nextLong());
            }

            Collections.sort(anglesOfPieces);

            long solution = D - 1;

            for (int i = 0; i < anglesOfPieces.size(); i++) {
                long angleSize = anglesOfPieces.get(i);
                long cutsNecessary = 0;
                long piecesNeededLeft = D;
                long amountGreaterPieces = 0;

                for (Long angleSizeOfComparisonPiece : anglesOfPieces) {
                    if (angleSize == angleSizeOfComparisonPiece) {
                        piecesNeededLeft--;
                    } else if (angleSizeOfComparisonPiece > angleSize && angleSizeOfComparisonPiece % angleSize == 0) {
                        long multiple = angleSizeOfComparisonPiece / angleSize;
                        long piecesCut = Math.min(piecesNeededLeft, multiple);
                        piecesNeededLeft -= multiple;
                        cutsNecessary = (cutsNecessary + Math.min(piecesCut, (multiple - 1)));
                    } else if (angleSizeOfComparisonPiece > angleSize) {
                        amountGreaterPieces++;
                    }
                    if (piecesNeededLeft <= 0) {
                        break;
                    }
                }

                if (piecesNeededLeft > 0 && amountGreaterPieces >= piecesNeededLeft) {
                    cutsNecessary += piecesNeededLeft;
                } else if (piecesNeededLeft > 0) {
                    cutsNecessary = D;
                }

                solution = Math.min(cutsNecessary, solution);
            }


            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}
