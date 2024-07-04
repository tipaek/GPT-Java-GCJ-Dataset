import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> digitMapping = new HashMap<>();
            Set<Character> allDigits = new HashSet<>();

            for (int i = 0; i < 10000; i++) {
                long M = scanner.nextLong();
                String R = scanner.next();
                int digitCount = (int) Math.log10(M) + 1;

                if (M > 0 && digitCount == R.length()) {
                    char firstChar = R.charAt(0);
                    if (!digitMapping.containsKey(firstChar) || digitMapping.get(firstChar) > M) {
                        digitMapping.put(firstChar, (int) M);
                    }
                }

                for (char ch : R.toCharArray()) {
                    allDigits.add(ch);
                }
            }

            char[] result = new char[10];
            for (Map.Entry<Character, Integer> entry : digitMapping.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }

            for (char ch : allDigits) {
                if (!digitMapping.containsKey(ch)) {
                    result[0] = ch;
                }
            }

            System.out.print("Case #" + t + ": ");
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}