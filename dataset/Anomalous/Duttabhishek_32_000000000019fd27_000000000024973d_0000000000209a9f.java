import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int pairs = Character.getNumericValue(characters[0]);
        for (int i = 0; i < pairs; i++) {
            result.append('(');
        }
        result.append(pairs);

        for (char character : characters) {
            int digit = Character.getNumericValue(character);
            if (digit == pairs) {
                result.append(digit);
            }
        }

        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }
}