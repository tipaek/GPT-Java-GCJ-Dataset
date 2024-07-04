import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int targetNumber = input.nextInt();
            double target = targetNumber;
            int currentSum = 0;
            double row = 1;
            double col = 1;
            int caseNumber = i + 1;

            System.out.println("Case #" + caseNumber + ":");

            while (currentSum < targetNumber) {
                currentSum += (int) Math.round(calculatePascal(row, col));
                System.out.println((int) row + " " + (int) col);

                if (currentSum < target / 3) {
                    if ((row + 1) % 2 == 0) {
                        col += 1;
                    }
                    row += 1;
                } else if (col == row) {
                    col += 1;
                    row += 1;
                } else {
                    col += 1;
                }
            }
        }
    }

    public static double calculatePascal(double row, double col) {
        double result = 1.0;
        for (int s = 0; s < col - 1; s++) {
            result = result * (row - 1 - s) / (s + 1);
        }
        return result;
    }
}