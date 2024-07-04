import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> characterToDigitMap = new HashMap<>();
            Set<Character> allDigits = new HashSet<>();
            long M;

            for (int i = 0; i < 10000; i++) {
                M = scanner.nextLong();
                String R = scanner.next();
                int digitCount = 1;

                while (M > 9) {
                    digitCount++;
                    M /= 10;
                }

                if (M != -1 && digitCount == R.length()) {
                    char firstChar = R.charAt(0);
                    if (!characterToDigitMap.containsKey(firstChar) || characterToDigitMap.get(firstChar) > M) {
                        characterToDigitMap.put(firstChar, (int) M);
                    }
                    for (char ch : R.toCharArray()) {
                        allDigits.add(ch);
                    }
                }
            }

            char[] result = new char[10];
            for (Map.Entry<Character, Integer> entry : characterToDigitMap.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }

            for (char ch : allDigits) {
                if (!characterToDigitMap.containsKey(ch)) {
                    result[0] = ch;
                }
            }

            System.out.print("Case #" + t + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }

        scanner.close();
    }
}