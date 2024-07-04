import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; ++i) {
            int unknown = scanner.nextInt(); // ???

            Map<Character, Range> characterRangeMap = new HashMap<>();
            for (int n = 0; n < 10000; ++n) {
                int number = scanner.nextInt();
                String str = scanner.next();
                int tempNumber = number;

                if (tempNumber == -1) {
                    return;
                }

                for (int index = str.length() - 1; index >= 0; --index) {
                    char character = str.charAt(index);
                    int digit = tempNumber % 10;
                    Range range = characterRangeMap.getOrDefault(character, new Range());

                    if (tempNumber < 10) {
                        range.end = Math.min(range.end, digit);
                    }

                    if (Integer.toString(tempNumber).length() > Integer.toString(tempNumber - 1).length() && index + 1 == Integer.toString(tempNumber).length()) {
                        range.end = 0;
                    }

                    characterRangeMap.put(character, range);
                    tempNumber /= 10;
                }
            }

            char[] result = new char[10];
            for (Map.Entry<Character, Range> entry : characterRangeMap.entrySet()) {
                result[entry.getValue().end] = entry.getKey();
            }

            System.out.println("Case #" + (i + 1) + ": " + new String(result));
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