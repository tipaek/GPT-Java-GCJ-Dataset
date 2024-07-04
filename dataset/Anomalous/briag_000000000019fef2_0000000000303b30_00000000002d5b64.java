import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            // Read size of data
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            int moves = (rows - 1) * (columns - 1);

            System.out.println("Case #" + caseNumber + ": " + moves);
            int deckSizeToLeave = rows - 1;
            int toMove = rows * columns - rows;

            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < columns - 1; j++) {
                    System.out.println(toMove + " " + deckSizeToLeave);
                    toMove--;
                }
                deckSizeToLeave--;
            }
        }
    }
}