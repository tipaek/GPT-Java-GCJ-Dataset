import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int b = input.nextInt();
            int c = input.nextInt();

            if (c % b == 0 && b <= c && c <= b * b) {
                int quotient = c / b;
                int[][] matrix = new int[b][b];

                // Fill the first row of the matrix
                for (int col = 0; col < b; col++) {
                    if (quotient > b) {
                        quotient -= b;
                    }
                    matrix[0][col] = quotient;
                    quotient++;
                }

                // Fill the rest of the matrix based on the first row
                for (int row = 1; row < b; row++) {
                    for (int col = 0; col < b; col++) {
                        if (matrix[row - 1][col] - 1 == 0) {
                            matrix[row][col] = b;
                        } else {
                            matrix[row][col] = matrix[row - 1][col] - 1;
                        }
                    }
                }

                System.out.println("Case #" + caseNum + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int col = 0; col < b; col++) {
                        System.out.print(row[col]);
                        if (col != b - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }

        input.close();
    }
}