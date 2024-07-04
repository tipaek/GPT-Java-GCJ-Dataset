import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read the number of test cases
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            // Read the size parameters
            int S = scanner.nextInt();
            int R = scanner.nextInt();

            // Calculate the number of moves
            int numberOfMoves = (R - 1) * (S - 1);

            // Output the result for this test case
            System.out.println("Case #" + testCase + ": " + numberOfMoves);

            int deckSizeRemaining = S - 1;
            int cardsToMove = R * S - S;

            // Iterate through the deck sizes
            for (int i = 0; i < S - 1; i++) {
                for (int j = 0; j < R - 1; j++) {
                    System.out.println(cardsToMove + " " + deckSizeRemaining);
                    cardsToMove--;
                }
                deckSizeRemaining--;
            }
        }

        scanner.close();
    }
}