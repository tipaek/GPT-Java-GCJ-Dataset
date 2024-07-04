import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= testCaseCount; i++) {
                processCase(reader, i);
            }
        }
    }

    private static void processCase(BufferedReader reader, int caseNumber) throws Exception {
        String input = reader.readLine();
        int[] digits = input.chars().map(c -> c - '0').toArray();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int digit : digits) {
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}