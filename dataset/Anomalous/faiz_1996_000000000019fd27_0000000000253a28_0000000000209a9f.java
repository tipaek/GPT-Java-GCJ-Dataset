import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> inputs = new ArrayList<>();

        while (t-- > 0) {
            String input = scanner.next();
            if (input.length() >= 1 && input.length() <= 100) {
                inputs.add(input);
            }
        }
        scanner.close();

        for (int i = 0; i < inputs.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + processString(inputs.get(i)));
        }
    }

    private static String processString(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}