import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int columns = scanner.nextInt();
            int[][] matrix = new int[15][columns];

            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < columns; col++) {
                    System.out.println(col + 1);
                    matrix[row][col] = scanner.nextInt();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int col = 0; col < columns; col++) {
                int value = matrix[0][col];
                for (int row = 1; row < 15; row++) {
                    value = matrix[row][col];
                }
                result.append(value);
            }

            System.out.println(result.toString());
            char response = scanner.next().charAt(0);
            if (response == 'N') {
                break;
            }
        }

        scanner.close();
    }
}