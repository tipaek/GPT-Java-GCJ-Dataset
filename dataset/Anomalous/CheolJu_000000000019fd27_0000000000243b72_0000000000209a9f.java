import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // move to the next line

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();

            if (!input.contains("1")) {
                System.out.println("Case #" + (i + 1) + ": " + input);
                continue;
            }

            if (!input.contains("0")) {
                System.out.println("Case #" + (i + 1) + ": (" + input + ")");
                continue;
            }

            int openParentheses = 0;
            for (char c : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);

                while (openParentheses < currentDigit) {
                    output.append("(");
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    output.append(")");
                    openParentheses--;
                }
                output.append(c);
            }

            while (openParentheses > 0) {
                output.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}