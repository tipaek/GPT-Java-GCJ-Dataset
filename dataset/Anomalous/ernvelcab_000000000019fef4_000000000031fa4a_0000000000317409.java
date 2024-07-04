import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(bufferedReader.readLine());

            for (int c = 1; c <= numberOfCases; c++) {
                String[] parts = bufferedReader.readLine().split(" ");
                int peppurrX = Integer.parseInt(parts[0]);
                int peppurrY = Integer.parseInt(parts[1]);
                String peppurrMoves = parts[2];
                int totalPeppurMoves = peppurrMoves.length();

                int currentMinute = 0;
                boolean caught = (peppurrX == 0 && peppurrY == 0);

                while (!caught && currentMinute < totalPeppurMoves) {
                    char nextPeppurrMove = peppurrMoves.charAt(currentMinute);

                    switch (nextPeppurrMove) {
                        case 'N': peppurrY++; break;
                        case 'S': peppurrY--; break;
                        case 'E': peppurrX++; break;
                        case 'W': peppurrX--; break;
                    }

                    currentMinute++;
                    caught = isInsideCenteredSquare(peppurrX, peppurrY, currentMinute) &&
                             calculateTotalMovesRequired(0, 0, peppurrX, peppurrY) <= currentMinute;
                }

                System.out.println("Case #" + c + ": " + (caught ? currentMinute : "IMPOSSIBLE"));
            }
        }
    }

    private static boolean isInsideCenteredSquare(int x, int y, int halfSquare) {
        return -halfSquare <= x && x <= halfSquare && -halfSquare <= y && y <= halfSquare;
    }

    private static int calculateTotalMovesRequired(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}