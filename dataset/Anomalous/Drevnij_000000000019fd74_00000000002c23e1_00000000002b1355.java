import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] floor = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            int totalSolution = 0;
            boolean hasElimination = true;

            while (hasElimination) {
                hasElimination = false;
                int[][] updatedFloor = new int[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        totalSolution += floor[i][j];
                        if (floor[i][j] != 0 && shouldEliminate(floor, i, j)) {
                            updatedFloor[i][j] = 0;
                            hasElimination = true;
                        } else {
                            updatedFloor[i][j] = floor[i][j];
                        }
                    }
                }

                floor = updatedFloor;
            }

            System.out.println("Case #" + caseNumber + ": " + totalSolution);
        }
    }

    private static boolean shouldEliminate(int[][] floor, int row, int col) {
        int up = 0, down = 0, left = 0, right = 0;

        for (int i = row - 1; i >= 0; i--) {
            if (floor[i][col] > 0) {
                up = floor[i][col];
                break;
            }
        }

        for (int i = row + 1; i < floor.length; i++) {
            if (floor[i][col] > 0) {
                down = floor[i][col];
                break;
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (floor[row][i] > 0) {
                left = floor[row][i];
                break;
            }
        }

        for (int i = col + 1; i < floor[row].length; i++) {
            if (floor[row][i] > 0) {
                right = floor[row][i];
                break;
            }
        }

        int partners = 0;
        if (up > 0) partners++;
        if (down > 0) partners++;
        if (left > 0) partners++;
        if (right > 0) partners++;

        if (partners == 0) return false;
        return up + down + left + right > floor[row][col] * partners;
    }
}