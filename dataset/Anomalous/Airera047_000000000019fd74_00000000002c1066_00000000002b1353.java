import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int targetSum = input.nextInt();
            int currentSum = 0;
            int row = 1, col = 1;
            int caseNumber = i + 1;

            System.out.println("Case #" + caseNumber + ":");

            while (currentSum <= targetSum) {
                currentSum += calculatePascal(row, col);
                System.out.println(row + " " + col);

                if (currentSum < targetSum / 3) {
                    if ((row + 1) % 2 == 0) {
                        col++;
                    }
                    row++;
                } else if (col == row) {
                    col++;
                    row++;
                } else {
                    col++;
                }
            }
        }
    }

    public static int calculatePascal(int row, int col) {
        int result = 1;
        for (int s = 0; s < col - 1; s++) {
            result = result * (row - 1 - s) / (s + 1);
        }
        return result;
    }
}