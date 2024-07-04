import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] field = new int[rows][cols];
            int[][] eliminationField = new int[rows][cols];
            int totalScore = 0;
            int eliminationCount = 1;
            int round = 1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    field[i][j] = scanner.nextInt();
                    totalScore += field[i][j];
                }
            }

            while (eliminationCount > 0) {
                eliminationCount = 0;
                int roundScore = 0;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (eliminationField[i][j] == 0) {
                            int neighborSum = 0;
                            int neighborCount = 0;

                            if (i > 0 && (eliminationField[i - 1][j] == 0 || eliminationField[i - 1][j] == round)) {
                                neighborSum += field[i - 1][j];
                                neighborCount++;
                            }
                            if (j > 0 && (eliminationField[i][j - 1] == 0 || eliminationField[i][j - 1] == round)) {
                                neighborSum += field[i][j - 1];
                                neighborCount++;
                            }
                            if (j < cols - 1 && (eliminationField[i][j + 1] == 0 || eliminationField[i][j + 1] == round)) {
                                neighborSum += field[i][j + 1];
                                neighborCount++;
                            }
                            if (i < rows - 1 && (eliminationField[i + 1][j] == 0 || eliminationField[i + 1][j] == round)) {
                                neighborSum += field[i + 1][j];
                                neighborCount++;
                            }

                            if (neighborCount > 0 && field[i][j] < ((float) neighborSum / neighborCount)) {
                                eliminationCount++;
                                eliminationField[i][j] = round;
                            } else {
                                roundScore += field[i][j];
                            }
                        }
                    }
                }

                if (eliminationCount > 0) {
                    totalScore += roundScore;
                }
                round++;
            }
            results.add("Case #" + (t + 1) + ": " + totalScore);
        }

        for (String result : results) {
            System.out.println(result);
        }
        scanner.close();
    }
}