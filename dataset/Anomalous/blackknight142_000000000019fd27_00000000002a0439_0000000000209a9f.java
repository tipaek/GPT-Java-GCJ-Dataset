import java.util.*;
import java.io.*;

public class NestedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputString = scanner.next();
            ArrayList<Integer> digits = new ArrayList<>();
            for (char ch : inputString.toCharArray()) {
                digits.add(Character.getNumericValue(ch));
            }
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }
            System.out.println("Case #" + caseIndex + ": " + output.toString());
        }
    }
}