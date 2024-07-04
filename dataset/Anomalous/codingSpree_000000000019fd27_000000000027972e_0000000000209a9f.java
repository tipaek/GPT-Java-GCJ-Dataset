import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = generateNestedString(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String generateNestedString(String input) {
        StringBuilder nestedString = new StringBuilder();
        int previousDepth = 0;

        for (char digitChar : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(digitChar);

            if (currentDepth > previousDepth) {
                for (int i = 0; i < currentDepth - previousDepth; i++) {
                    nestedString.append("(");
                }
            } else if (currentDepth < previousDepth) {
                for (int i = 0; i < previousDepth - currentDepth; i++) {
                    nestedString.append(")");
                }
            }

            nestedString.append(currentDepth);
            previousDepth = currentDepth;
        }

        for (int i = 0; i < previousDepth; i++) {
            nestedString.append(")");
        }

        return nestedString.toString();
    }
}