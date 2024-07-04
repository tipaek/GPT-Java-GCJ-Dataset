import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<Integer> scores = new ArrayList<>();
    static int[][] triangle = new int[500][500];

    public static void main(String[] args) {
        readInput();

        preparePascalTriangle();

        int i = 1;

        for (int score : scores) {
            computeScore(score, i);
            i++;
        }
    }

    private static void preparePascalTriangle() {
        triangle[0][0] = 1;

        for (int i = 1; i < 500; i++) {
            for (int j = 0; j <= i; j++) {
                int left = 0;
                if (j != 0) {
                    left = triangle[i - 1][j - 1];
                }
                int right = triangle[i - 1][j];
                triangle[i][j] = left + right;
            }
        }
    }

    private static void computeScore(int score, int testcaseId) {
        List<int[]> coordinates = new ArrayList<>();

        int[] firstCoordinate = new int[2];
        firstCoordinate[0] = 0;
        firstCoordinate[1] = 0;
        coordinates.add(firstCoordinate);

        int currentScore = 1;

        int row = 1;
        int column = 1;

        while (currentScore < score) {
            if ((currentScore + triangle[row][column]) <= score) {
                currentScore += triangle[row][column];
                int[] coordinate = new int[2];
                coordinate[0] = row;
                coordinate[1] = column;
                coordinates.add(coordinate);
                row++;
            } else {
                column--;
                row--;
                currentScore += triangle[row][column];
                int[] coordinate = new int[2];
                coordinate[0] = row;
                coordinate[1] = column;
                coordinates.add(coordinate);
                break;
            }
        }

        while (currentScore < score) {
            row++;
            currentScore += triangle[row][column];
            int[] coordinate = new int[2];
            coordinate[0] = row;
            coordinate[1] = column;
            coordinates.add(coordinate);
        }

        printSolution(testcaseId, coordinates);
    }

    private static void printSolution(int testcaseId, List<int[]> coordinates) {
        System.out.println("case #" + testcaseId + ": ");

        for (int[] coordinate : coordinates) {
            System.out.println((coordinate[0] + 1) + " " + (coordinate[1] + 1));
        }
    }

    public static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                int score = Integer.parseInt(line);

                scores.add(score);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
