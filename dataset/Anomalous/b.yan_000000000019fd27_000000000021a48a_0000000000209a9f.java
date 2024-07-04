import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int depth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (depth < digit) {
                    result.append('(');
                    depth++;
                }
                while (depth > digit) {
                    result.append(')');
                    depth--;
                }

                result.append(digit);
            }

            while (depth > 0) {
                result.append(')');
                depth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}