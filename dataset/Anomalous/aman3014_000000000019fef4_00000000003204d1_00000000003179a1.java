import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int u = scanner.nextInt(); // ???

            Map<Character, Range> characterRangeMap = new HashMap<>();
            for (int n = 0; n < 10000; n++) {
                int number = scanner.nextInt();
                String s = scanner.next();
                int tempNumber = number;

                if (tempNumber == -1) {
                    return;
                }

                for (int index = s.length() - 1; index >= 0; index--) {
                    char c = s.charAt(index);
                    int digit = tempNumber % 10;
                    Range range = characterRangeMap.getOrDefault(c, new Range());

                    if (tempNumber < 10) {
                        range.end = Math.min(range.end, digit);
                    }

                    if (Integer.toString(tempNumber).length() > Integer.toString(tempNumber - 1).length() && index + 1 == Integer.toString(tempNumber).length()) {
                        System.out.println(tempNumber);
                        range.end = 0;
                    }

                    characterRangeMap.put(c, range);
                    tempNumber /= 10;
                }
            }

            char[] answer = new char[10];
            for (Map.Entry<Character, Range> entry : characterRangeMap.entrySet()) {
                answer[entry.getValue().end] = entry.getKey();
            }

            System.out.println("Case #" + (i + 1) + ": " + new String(answer));
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