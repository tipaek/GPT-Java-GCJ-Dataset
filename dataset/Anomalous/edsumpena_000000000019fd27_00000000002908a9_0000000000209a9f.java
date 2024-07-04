import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputString = scanner.next();
            String result = getNestedString(inputString);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String getNestedString(String input) {
        for (int digit = 1; digit < 10; digit++) {
            List<Integer> ranges = findRanges(input, digit);

            for (int i = ranges.size() - 1; i >= 0; i -= 2) {
                int start = ranges.get(i - 1);
                int end = ranges.get(i);
                input = input.substring(0, start) + "(" + input.substring(start, end) + ")" + input.substring(end);
            }
        }
        return input;
    }

    private static List<Integer> findRanges(String input, int threshold) {
        List<Integer> ranges = new ArrayList<>();
        int start = -1;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            if (currentDigit >= threshold && start == -1) {
                start = i;
            } else if (currentDigit < threshold && start != -1) {
                ranges.add(start);
                ranges.add(i);
                start = -1;
            }
        }

        if (start != -1) {
            ranges.add(start);
            ranges.add(input.length());
        }

        return ranges;
    }
}