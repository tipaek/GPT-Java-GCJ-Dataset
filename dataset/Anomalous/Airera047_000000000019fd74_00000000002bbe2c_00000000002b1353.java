import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int targetNumber = input.nextInt();
            int currentSum = 0;
            int row = 1;
            int col = 1;

            System.out.println("Case #" + (i + 1) + ":");

            while (currentSum < targetNumber) {
                currentSum += calculatePascalValue(row, col);
                System.out.println(row + " " + col);

                if (currentSum < targetNumber / 2) {
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

    public static int calculatePascalValue(int row, int col) {
        int result = 1;
        for (int i = 0; i < col - 1; i++) {
            result = result * (row - 1 - i) / (i + 1);
        }
        return result;
    }
}