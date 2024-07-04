import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char character : input.toCharArray()) {
                int digit = Character.getNumericValue(character);

                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }
                result.append(character);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}