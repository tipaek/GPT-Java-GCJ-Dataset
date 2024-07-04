import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String result = processDepth(scanner.next());
            System.out.println("Case #" + t + ": " + result);
        }
    }

    public static String processDepth(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char c : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(c);

            while (previousDepth < currentDepth) {
                result.append('(');
                previousDepth++;
            }

            while (previousDepth > currentDepth) {
                result.append(')');
                previousDepth--;
            }

            result.append(c);
        }

        while (previousDepth > 0) {
            result.append(')');
            previousDepth--;
        }

        return result.toString();
    }
}