import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> charToDigitMap = new HashMap<>();
            Set<Character> allDigitsSet = new HashSet<>();

            for (int i = 0; i < 10000; i++) {
                long M = scanner.nextLong();
                String R = scanner.next();
                int digitCount = 1;

                while (M > 9) {
                    digitCount++;
                    M /= 10;
                }

                if (M != -1 && digitCount == R.length()) {
                    char firstChar = R.charAt(0);
                    if (!charToDigitMap.containsKey(firstChar) || charToDigitMap.get(firstChar) > M) {
                        charToDigitMap.put(firstChar, (int) M);
                    }
                    for (char ch : R.toCharArray()) {
                        allDigitsSet.add(ch);
                    }
                }
            }

            char[] result = new char[10];
            Arrays.fill(result, ' ');

            for (Map.Entry<Character, Integer> entry : charToDigitMap.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }

            for (char ch : allDigitsSet) {
                if (!charToDigitMap.containsKey(ch)) {
                    result[0] = ch;
                }
            }

            System.out.print("Case #" + t + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }

        scanner.close();
    }
}