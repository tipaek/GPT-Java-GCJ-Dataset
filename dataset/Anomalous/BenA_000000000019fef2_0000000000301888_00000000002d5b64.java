import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] inputNumbers = scanner.nextLine().split(" ");
            int r = Integer.parseInt(inputNumbers[0]);
            int s = Integer.parseInt(inputNumbers[1]);
            int result = (r * s) - r - s + 1;

            System.out.println("Case #" + caseNumber + ": " + result);
            printDecks(r, s);
        }
    }

    private static void printDecks(int r, int s) {
        int sortIndex = 1;
        int decrement = r - 1;

        while (decrement > 0) {
            for (int i = 1; i < s; i++) {
                System.out.println((r * s - decrement - sortIndex) + " " + decrement);
                sortIndex++;
            }
            decrement--;
            sortIndex++;
        }
    }
}