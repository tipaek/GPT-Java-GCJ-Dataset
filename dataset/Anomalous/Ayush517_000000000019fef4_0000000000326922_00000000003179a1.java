import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int u = scanner.nextInt();
            char[] digits = new char[10];
            Arrays.fill(digits, '?');
            Map<Character, Integer> characterIndexMap = new HashMap<>();

            for (int i = 1; i <= 10000; i++) {
                String number = String.valueOf(scanner.nextLong());
                String s = scanner.next();

                if (s.length() == 1) {
                    characterIndexMap.putIfAbsent(s.charAt(0), 10);
                } else {
                    int index = characterIndexMap.getOrDefault(s.charAt(0), 10);
                    index = Math.min(index, number.charAt(0) - '0');
                    characterIndexMap.put(s.charAt(0), index);

                    for (int j = 1; j < s.length(); j++) {
                        index = characterIndexMap.getOrDefault(s.charAt(j), 10);
                        characterIndexMap.put(s.charAt(j), index);
                    }
                }
            }

            for (Map.Entry<Character, Integer> entry : characterIndexMap.entrySet()) {
                if (entry.getValue() != 10) {
                    digits[entry.getValue()] = entry.getKey();
                }
            }

            for (Map.Entry<Character, Integer> entry : characterIndexMap.entrySet()) {
                if (entry.getValue() == 10) {
                    for (int i = 0; i < 10; i++) {
                        if (digits[i] == '?') {
                            digits[i] = entry.getKey();
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + test + ": " + new String(digits));
        }
    }
}