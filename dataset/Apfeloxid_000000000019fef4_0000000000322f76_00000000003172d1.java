import java.util.*;

public class SolutionC {

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

                for (int j = i; j < anglesOfPieces.size(); j++) {
                    if(angleSize == anglesOfPieces.get(j)) {
                        piecesNeededLeft--;
                    } else if (anglesOfPieces.get(j) > angleSize && anglesOfPieces.get(j) % angleSize == 0) {
                        long multiple = anglesOfPieces.get(j) / angleSize;
                        piecesNeededLeft -= multiple;
                        cutsNecessary = (cutsNecessary + (multiple - 1));
                    } else if (anglesOfPieces.get(j) > angleSize){
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
