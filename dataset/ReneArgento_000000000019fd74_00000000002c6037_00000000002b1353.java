import java.util.Random;
import java.util.Scanner;

/**
 * Created by Rene Argento on 03/04/20.
 */
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b1353
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        int[][] triangle = computeTriangle();

        for (int t = 1; t <= tests; t++) {
            int sum = scanner.nextInt();
            boolean[][] visited = new boolean[500][500];
            String directions = getDirections(triangle, sum, visited);
            System.out.println("Case #" + t + ": " + directions);
        }
    }

    private static String getDirections(int[][] triangle, int sum, boolean[][] visited) {
        int currentSum = 0;
        StringBuilder directions = new StringBuilder();
        int row = 0;
        int column = 0;
        Random random = new Random();

        while (currentSum < sum) {
            visited[row][column] = true;
            currentSum += triangle[row][column];
            directions.append("\n" + (row + 1) + " " + (column + 1));
            //System.out.println("Current: " + currentSum);

            int maxValue = Integer.MIN_VALUE;
            int nextRow = 0;
            int nextColumn = 0;

            int[] neighborRow = {-1, -1, 0, 0, 1, 1};
            int[] neighborColumn = {-1, 0, -1, 1, 0, 1};

            for (int i = 0; i < neighborRow.length; i++) {
                int newRow = random.nextInt(6);//row + neighborRow[i];
                int newColumn = random.nextInt(6);//column + neighborColumn[i];

                if (!isValid(triangle, newRow, newColumn) || visited[newRow][newColumn]) {
                    continue;
                }

                nextRow = newRow;
                nextColumn = newColumn;
                break;

//                if (currentSum + triangle[newRow][newColumn] <= sum && triangle[newRow][newColumn] > maxValue) {
//                    maxValue = triangle[newRow][newColumn];
//                    nextRow = newRow;
//                    nextColumn = newColumn;
//                }
            }

            row = nextRow;
            column = nextColumn;
        }

        return directions.toString();
    }

    private static int[][] computeTriangle() {
        int[][] triangle = new int[500][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j < triangle[i].length; j++) {
                int value;
                if (j == 0 || j == triangle[i].length - 1) {
                    value = 1;
                } else {
                    value = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
                triangle[i][j] = value;
            }
        }
        return triangle;
    }

    private static boolean isValid(int[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length;
    }

}
