import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int u = scanner.nextInt();  // Unused variable

            Map<Character, Range> charRangeMap = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                int number = scanner.nextInt();
                String s = scanner.next();
                int tempNumber = number;

                if (tempNumber == -1) {
                    return;
                }

                for (int j = s.length() - 1; j >= 0; j--) {
                    char currentChar = s.charAt(j);
                    int digit = tempNumber % 10;
                    Range range = charRangeMap.getOrDefault(currentChar, new Range());

                    if (tempNumber < 10) {
                        range.end = Math.min(range.end, digit);
                    }

                    if (Integer.toString(tempNumber).length() > Integer.toString(tempNumber - 1).length() && j + 1 == Integer.toString(tempNumber).length()) {
                        range.end = 0;
                    }

                    charRangeMap.put(currentChar, range);
                    tempNumber /= 10;
                }
            }

            char[] result = new char[10];
            for (Map.Entry<Character, Range> entry : charRangeMap.entrySet()) {
                result[entry.getValue().end] = entry.getKey();
            }

            System.out.println("Case #" + (testCase + 1) + ": " + new String(result));
        }
    }
}

class Range {
    int start = 0;
    int end = 9;

    @Override
    public String toString() {
        return start + " -> " + end;
    }
}