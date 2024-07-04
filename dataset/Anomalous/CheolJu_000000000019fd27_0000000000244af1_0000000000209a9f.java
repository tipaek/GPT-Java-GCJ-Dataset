import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String inputString = scanner.next();

            if (!inputString.contains("1")) {
                System.out.println("Case #" + testCase + ": " + inputString);
                continue;
            }

            if (!inputString.contains("0")) {
                System.out.println("Case #" + testCase + ": " + "(" + inputString + ")");
                continue;
            }

            StringBuilder output = new StringBuilder();
            int openParentheses = 0;

            for (char c : inputString.toCharArray()) {
                int digit = Character.getNumericValue(c);
                while (openParentheses < digit) {
                    output.append("(");
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    output.append(")");
                    openParentheses--;
                }
                output.append(c);
            }

            while (openParentheses > 0) {
                output.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + testCase + ": " + output.toString());
        }
    }
}