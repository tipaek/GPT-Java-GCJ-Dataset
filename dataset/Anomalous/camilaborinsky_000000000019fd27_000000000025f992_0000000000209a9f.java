import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        String[] outputs = new String[testCaseCount];
        
        for (int i = 0; i < testCaseCount; i++) {
            String input = scanner.next();
            outputs[i] = createBalancedString(input);
            System.out.println("Case #" + (i + 1) + ": " + outputs[i]);
        }
    }

    public static String createBalancedString(String input) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int nextDigit = (i < input.length() - 1) ? Character.getNumericValue(input.charAt(i + 1)) : 0;

            while (balance < currentDigit) {
                result.append("(");
                balance++;
            }
            while (balance > currentDigit) {
                result.append(")");
                balance--;
            }

            result.append(currentDigit);

            if (i == input.length() - 1) {
                while (balance > 0) {
                    result.append(")");
                    balance--;
                }
            }
        }

        return result.toString();
    }
}