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
            StringBuilder resultBuilder = new StringBuilder();

            for (int row = 1; row < rows; row++) {
                int upperPile = 0;
                for (int col = 1; col < columns; col++) {
                    int a = rows * (columns - col) + upperPile;
                    int b = rows * columns - a - currentPile;
                    upperPile = b;
                    moveCount++;
                    currentPile++;
                    resultBuilder.append(a).append(" ").append(b).append("\n");
                }
            }

            System.out.println(String.format("Case #%d: %d", testCase, moveCount));
            System.out.print(resultBuilder.toString());
        }
    }
}