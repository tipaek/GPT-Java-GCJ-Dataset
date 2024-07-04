import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static String convert(String number) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();

        for (char digitChar : number.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            int depthChange = digit - currentDepth;

            if (depthChange > 0) {
                result.append("(".repeat(depthChange));
            } else if (depthChange < 0) {
                result.append(")".repeat(-depthChange));
            }

            result.append(digit);
            currentDepth = digit;
        }

        result.append(")".repeat(currentDepth));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String number = scanner.next();
            String converted = convert(number);
            System.out.println("Case #" + i + ": " + converted);
        }
    }
}