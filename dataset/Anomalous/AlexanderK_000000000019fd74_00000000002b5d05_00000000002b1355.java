import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            handleInput(reader);
        }
    }

    private static class InputData {
        int[][] grid;

        public InputData(BufferedReader reader) throws IOException {
            String[] dimensions = reader.readLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            grid = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                String[] values = reader.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = Integer.parseInt(values[j]);
                }
            }
        }
    }

    private static class Result {
        BigInteger interestLevel;

        public Result(BigInteger interestLevel) {
            this.interestLevel = interestLevel;
        }

        @Override
        public String toString() {
            return interestLevel.toString();
        }
    }

    public static void handleInput(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + computeSolution(new InputData(reader)));
        }
    }

    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    private static class Dancer {
        int row, col, level;
        Dancer[] neighbors = new Dancer[4];
        boolean isEliminated;
    }

    private static Result computeSolution(InputData inputData) {
        Set<Dancer> dancers = new HashSet<>(inputData.grid.length * inputData.grid[0].length);
        Dancer[] rowTrack = new Dancer[inputData.grid[0].length];
        Dancer[] colTrack = new Dancer[inputData.grid.length];

        for (int i = 0; i < inputData.grid.length; i++) {
            for (int j = 0; j < inputData.grid[0].length; j++) {
                Dancer dancer = new Dancer();
                dancer.row = i;
                dancer.col = j;
                dancer.level = inputData.grid[i][j];
                if (i > 0) {
                    dancer.neighbors[NORTH] = rowTrack[j];
                    rowTrack[j].neighbors[SOUTH] = dancer;
                }
                if (j > 0) {
                    dancer.neighbors[WEST] = colTrack[i];
                    colTrack[i].neighbors[EAST] = dancer;
                }
                rowTrack[j] = dancer;
                colTrack[i] = dancer;
                dancers.add(dancer);
            }
        }

        BigInteger totalInterestLevel = BigInteger.ZERO;
        while (true) {
            long currentInterest = 0;
            Set<Dancer> nextRoundDancers = new HashSet<>();
            int eliminatedCount = 0;

            for (Dancer dancer : dancers) {
                currentInterest += dancer.level;
                int sumLevels = 0;
                int neighborCount = 0;
                for (Dancer neighbor : dancer.neighbors) {
                    if (neighbor != null) {
                        sumLevels += neighbor.level;
                        neighborCount++;
                    }
                }
                if (dancer.level < (double) sumLevels / neighborCount) {
                    dancer.isEliminated = true;
                    eliminatedCount++;
                }
            }

            totalInterestLevel = totalInterestLevel.add(BigInteger.valueOf(currentInterest));
            if (eliminatedCount == 0) {
                break;
            }

            for (Iterator<Dancer> iterator = dancers.iterator(); iterator.hasNext();) {
                Dancer dancer = iterator.next();
                if (dancer.isEliminated) {
                    if (dancer.neighbors[NORTH] != null) {
                        dancer.neighbors[NORTH].neighbors[SOUTH] = dancer.neighbors[SOUTH];
                    }
                    if (dancer.neighbors[SOUTH] != null) {
                        dancer.neighbors[SOUTH].neighbors[NORTH] = dancer.neighbors[NORTH];
                    }
                    if (dancer.neighbors[EAST] != null) {
                        dancer.neighbors[EAST].neighbors[WEST] = dancer.neighbors[WEST];
                    }
                    if (dancer.neighbors[WEST] != null) {
                        dancer.neighbors[WEST].neighbors[EAST] = dancer.neighbors[EAST];
                    }
                    iterator.remove();
                }
            }
        }
        return new Result(totalInterestLevel);
    }
}