import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int test = 1; test <= testCount; test++) {
            StringBuilder result = new StringBuilder();
            String input = scanner.next();
            boolean inParentheses = false;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (currentDigit == 0 && inParentheses) {
                    result.append(")").append(currentDigit);
                    inParentheses = false;
                } else if (currentDigit == 1 && !inParentheses) {
                    result.append("(").append(currentDigit);
                    inParentheses = true;
                } else {
                    result.append(currentDigit);
                }

                if (i == input.length() - 1 && inParentheses) {
                    result.append(")");
                }
            }

            System.out.println("Case #" + test + ": " + result.toString());
        }
        scanner.close();
    }
}