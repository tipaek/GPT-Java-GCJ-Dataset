import java.util.Scanner;

/**
 * Solution to the problem solved by Julian Paniagua
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input

        for (int t = 1; t <= testCases; t++) {
            String zeroLedNumbers = scanner.nextLine();
            for (int i = 1; i <= 9; i++) {
                zeroLedNumbers = zeroLedNumbers.replaceAll("([" + i + "-9]+)", "($1)");
            }
            System.out.println("Case #" + t + ": " + zeroLedNumbers);
        }

        scanner.close();
    }
}