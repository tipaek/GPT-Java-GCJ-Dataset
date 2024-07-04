import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c++) {
				line = bufferedReader.readLine();
				final String parts[] = line.split(" ");
				int peppurrX = Integer.parseInt(parts[0]);
				int peppurrY = Integer.parseInt(parts[1]);
				final String peppurrMoves = parts[2];
				final int totalPeppurMoves = peppurrMoves.length();

				int currentMinute = 0;
				boolean caught = false;

				if ((peppurrX == 0) && (peppurrY == 0)) {
					caught = true;
				}

				while (!caught && (currentMinute < totalPeppurMoves)) {
					final char nextPeppurrMove = peppurrMoves.charAt(currentMinute);

					if (nextPeppurrMove == 'N') {
						peppurrY++;
					} else if (nextPeppurrMove == 'S') {
						peppurrY--;
					} else if (nextPeppurrMove == 'E') {
						peppurrX++;
					} else if (nextPeppurrMove == 'W') {
						peppurrX--;
					}
					currentMinute++;
					caught = insideCenteredSquare(peppurrX, peppurrY, currentMinute) && (calculateTotalMovesRequired(0, 0, peppurrX, peppurrY) <= currentMinute);
				}

				if (caught) {
					System.out.println("Case #" + c + ": " + currentMinute );
				} else {
					System.out.println("Case #" + c + ": IMPOSSIBLE");
				}
			}
        }
    }

    private static boolean insideCenteredSquare(final int x, final int y, final int halfSquare) {
        return ((-halfSquare <= x) && (x <= halfSquare) && (-halfSquare <= y) && (y <= halfSquare));
    }

    private static int calculateTotalMovesRequired(final int x1, final int y1, final int x2, final int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
