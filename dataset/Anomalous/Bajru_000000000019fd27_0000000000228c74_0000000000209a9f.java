import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            String result = solve(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(c);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}