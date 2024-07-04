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

        while (currentSum < sum) {
            visited[row][column] = true;
            if (currentSum + triangle[row][column] <= sum) {
                currentSum += triangle[row][column];
                directions.append("\n" + (row + 1) + " " + (column + 1));
            }

            if (column > 0 && isValid(triangle, row, column - 1) && !visited[row][column - 1]) {
                column--;
            } else if (column < triangle[row].length - 1 && isValid(triangle, row, column + 1) && !visited[row][column + 1]) {
                column++;
            } else {
                row++;
            }
        }

        return directions.toString();
    }

    private static int[][] computeTriangle() {
        int[][] triangle = new int[500][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j < triangle[i].length; j++) {
                int value;
                if (i == 0 || i == triangle[i].length - 1) {
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
