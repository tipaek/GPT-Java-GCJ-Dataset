import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            int moveCount = 0;
            int currentPile = 1;
            StringBuilder result = new StringBuilder();

            for (int row = 1; row < rows; row++) {
                int upperPile = 0;
                for (int col = 1; col < columns; col++) {
                    int firstPile = rows * (columns - col - (row - 1)) + upperPile;
                    int secondPile = rows * columns - firstPile - currentPile;
                    upperPile = secondPile;
                    moveCount++;
                    currentPile++;
                    result.append(firstPile).append(" ").append(secondPile).append("\n");
                }
            }

            System.out.printf("Case #%d: %d%n", testCase, moveCount);
            System.out.print(result.toString());
        }
    }
}