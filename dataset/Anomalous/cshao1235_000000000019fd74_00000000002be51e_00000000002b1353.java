import java.io.*;
import java.util.*;

public class Solution {
    private static final int MAX = 30;

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + " " + col;
        }
    }

    private static List<Position> generateTrivialPositions(int n) {
        List<Position> positions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            positions.add(new Position(i, 1));
        }
        return positions;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            List<Position> positions;

            if (n <= MAX) {
                positions = generateTrivialPositions(n);
            } else {
                positions = new ArrayList<>();
                int remainingSteps = n - MAX;
                int rowsToFill = MAX;
                boolean moveLeft = true;

                for (int row = 1; row <= MAX; row++) {
                    if (remainingSteps % 2 == 0) {
                        rowsToFill--;
                        int col = moveLeft ? 1 : row;
                        positions.add(new Position(row, col));
                    } else {
                        if (moveLeft) {
                            for (int col = 1; col <= row; col++) {
                                positions.add(new Position(row, col));
                            }
                        } else {
                            for (int col = row; col >= 1; col--) {
                                positions.add(new Position(row, col));
                            }
                        }
                        moveLeft = !moveLeft;
                    }
                    remainingSteps /= 2;
                }

                for (int row = MAX; row < MAX + rowsToFill; row++) {
                    int col = moveLeft ? 1 : row;
                    positions.add(new Position(row, col));
                }
            }

            System.out.println("Case #" + caseNum + ":");
            for (Position position : positions) {
                System.out.println(position);
            }
        }
        reader.close();
    }
}