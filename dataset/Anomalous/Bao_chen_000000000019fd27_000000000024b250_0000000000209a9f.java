import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            int[] digits = new int[input.length()];
            for (int j = 0; j < input.length(); j++) {
                digits[j] = Character.getNumericValue(input.charAt(j));
            }
            processCase(i, digits);
        }
    }

    private static void processCase(int caseNumber, int[] digits) {
        List<String> result = new ArrayList<>();
        int previousDigit = 0;

        for (int digit : digits) {
            int maxLength = digit * 2 + 1;
            String[] currentSegment = new String[maxLength];

            Arrays.fill(currentSegment, 0, digit, "(");
            currentSegment[digit] = String.valueOf(digit);
            Arrays.fill(currentSegment, digit + 1, maxLength, ")");

            if (previousDigit == 0) {
                Collections.addAll(result, currentSegment);
            } else {
                int offset = Math.min(digit, previousDigit);
                int startIndex = result.size() - offset;

                for (int k = offset; k < maxLength; k++) {
                    if (startIndex < result.size()) {
                        result.set(startIndex, currentSegment[k]);
                    } else {
                        result.add(currentSegment[k]);
                    }
                    startIndex++;
                }
            }
            previousDigit = digit;
        }

        StringBuilder output = new StringBuilder();
        for (String s : result) {
            output.append(s);
        }

        System.out.println("Case #" + caseNumber + ": " + output.toString());
    }
}