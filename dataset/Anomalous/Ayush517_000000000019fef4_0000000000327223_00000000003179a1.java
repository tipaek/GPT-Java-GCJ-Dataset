import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int u = scanner.nextInt();
            char[] result = new char[10];
            Arrays.fill(result, '?');
            HashMap<Character, Integer> charToIndexMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String number = scanner.next();
                String s = scanner.next();

                if (s.length() == 1) {
                    charToIndexMap.putIfAbsent(s.charAt(0), 10);
                } else {
                    int index = Math.min(charToIndexMap.getOrDefault(s.charAt(0), 10), number.charAt(0) - '0');
                    charToIndexMap.put(s.charAt(0), index);

                    for (int j = 1; j < s.length(); j++) {
                        charToIndexMap.putIfAbsent(s.charAt(j), 10);
                    }
                }
            }

            for (char c : charToIndexMap.keySet()) {
                int index = charToIndexMap.get(c);
                if (index != 10) {
                    result[index] = c;
                }
            }

            for (char c : charToIndexMap.keySet()) {
                if (charToIndexMap.get(c) == 10) {
                    for (int i = 0; i < 10; i++) {
                        if (result[i] == '?') {
                            result[i] = c;
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + new String(result));
        }
    }
}