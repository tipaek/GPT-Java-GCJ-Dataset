import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            String[] dimensions = reader.readLine().trim().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            int[][] danceFloor = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] rowValues = reader.readLine().trim().split(" ");
                for (int j = 0; j < cols; j++) {
                    danceFloor[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            output.append(calculateInterest(rows, cols, danceFloor)).append("\n");
        }

        System.out.print(output);
    }

    private static long calculateInterest(int rows, int cols, int[][] danceFloor) {
        long totalSkill = computeTotalSkill(danceFloor);
        long totalInterest = 0;
        int eliminations;
        boolean[][] immune = new boolean[rows][cols];

        do {
            totalInterest += totalSkill;
            eliminations = 0;
            boolean[][] toEliminate = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (danceFloor[i][j] != 0 && !immune[i][j]) {
                        int[] neighbors = findNeighbors(danceFloor, i, j, rows, cols);

                        int neighborSum = 0;
                        int neighborCount = 0;
                        for (int skill : neighbors) {
                            if (skill > 0) {
                                neighborSum += skill;
                                neighborCount++;
                            }
                        }

                        if (neighborCount == 0) {
                            immune[i][j] = true;
                        } else if (neighborSum / neighborCount > danceFloor[i][j]) {
                            toEliminate[i][j] = true;
                            eliminations++;
                            totalSkill -= danceFloor[i][j];
                        }
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (toEliminate[i][j]) {
                        danceFloor[i][j] = 0;
                    }
                }
            }
        } while (eliminations > 0);

        return totalInterest;
    }

    private static int[] findNeighbors(int[][] danceFloor, int row, int col, int rows, int cols) {
        int[] neighbors = new int[4];

        for (int j = col - 1; j >= 0; j--) {
            if (danceFloor[row][j] != 0) {
                neighbors[0] = danceFloor[row][j];
                break;
            }
        }

        for (int j = col + 1; j < cols; j++) {
            if (danceFloor[row][j] != 0) {
                neighbors[1] = danceFloor[row][j];
                break;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (danceFloor[i][col] != 0) {
                neighbors[2] = danceFloor[i][col];
                break;
            }
        }

        for (int i = row + 1; i < rows; i++) {
            if (danceFloor[i][col] != 0) {
                neighbors[3] = danceFloor[i][col];
                break;
            }
        }

        return neighbors;
    }

    private static long computeTotalSkill(int[][] danceFloor) {
        long totalSkill = 0;
        for (int[] row : danceFloor) {
            for (int skill : row) {
                totalSkill += skill;
            }
        }
        return totalSkill;
    }
}