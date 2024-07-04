import java.util.*;

public class SolutionC {

    private static final Scanner scanner = new Scanner(System.in);

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

                for (int j = i; j < anglesOfPieces.size(); j++) {
                    long currentAngle = anglesOfPieces.get(j);
                    if (angleSize == currentAngle) {
                        piecesNeededLeft--;
                    } else if (currentAngle > angleSize && currentAngle % angleSize == 0) {
                        long multiple = currentAngle / angleSize;
                        piecesNeededLeft -= multiple;
                        cutsNecessary += (multiple - 1);
                    } else if (currentAngle > angleSize) {
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