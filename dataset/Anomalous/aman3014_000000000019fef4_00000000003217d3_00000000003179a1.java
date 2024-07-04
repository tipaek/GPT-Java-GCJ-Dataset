import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        BigInteger ten = BigInteger.TEN;
        BigInteger negativeOne = BigInteger.valueOf(-1);

        for (int i = 0; i < testCases; i++) {
            int u = scanner.nextInt(); // Placeholder for an unknown value

            Map<Character, Range> characterRangeMap = new HashMap<>();
            for (int n = 0; n < 10000; n++) {
                BigInteger q = scanner.nextBigInteger();
                String s = scanner.next();
                if (q.equals(negativeOne)) {
                    return;
                }
                
                for (int index = s.length() - 1; index >= 0; index--) {
                    char character = s.charAt(index);
                    int digit = q.mod(ten).intValue();
                    Range range = characterRangeMap.getOrDefault(character, new Range());

                    if (q.compareTo(ten) < 0) {
                        range.end = Math.min(range.end, digit);
                    }

                    int length = q.toString().length();
                    if (length > q.add(negativeOne).toString().length() && index + 1 == length) {
                        range.end = 0;
                    }

                    characterRangeMap.put(character, range);
                    q = q.divide(ten);
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
}