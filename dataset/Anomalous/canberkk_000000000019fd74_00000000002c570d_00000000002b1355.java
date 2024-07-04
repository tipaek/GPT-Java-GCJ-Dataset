import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String result = "Case #" + caseNum + ": ";
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long totalScore = 0;
            int[][] dancers = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dancers[i][j] = scanner.nextInt();
                }
            }

            int[][] nextRoundDancers = new int[rows][cols];
            copyArray(dancers, nextRoundDancers);

            boolean isStable = false;
            while (!isStable) {
                isStable = true;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        totalScore += dancers[i][j];
                        if (dancers[i][j] != 0 && shouldEliminate(dancers, i, j)) {
                            isStable = false;
                            nextRoundDancers[i][j] = 0;
                        }
                    }
                }
                copyArray(nextRoundDancers, dancers);
            }

            writer.println(result + totalScore);
        }

        scanner.close();
        writer.close();
    }

    private static void copyArray(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[0].length);
        }
    }

    private static boolean shouldEliminate(int[][] dancers, int row, int col) {
        int neighborCount = 0;
        int neighborScore = 0;

        int x = row - 1;
        while (x >= 0 && dancers[x][col] == 0) x--;
        if (x >= 0) {
            neighborCount++;
            neighborScore += dancers[x][col];
        }

        x = row + 1;
        while (x < dancers.length && dancers[x][col] == 0) x++;
        if (x < dancers.length) {
            neighborCount++;
            neighborScore += dancers[x][col];
        }

        int y = col - 1;
        while (y >= 0 && dancers[row][y] == 0) y--;
        if (y >= 0) {
            neighborCount++;
            neighborScore += dancers[row][y];
        }

        y = col + 1;
        while (y < dancers[0].length && dancers[row][y] == 0) y++;
        if (y < dancers[0].length) {
            neighborCount++;
            neighborScore += dancers[row][y];
        }

        return neighborCount > 0 && dancers[row][col] * neighborCount < neighborScore;
    }
}