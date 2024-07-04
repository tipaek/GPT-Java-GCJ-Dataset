import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZero = new HashSet<>();
            Map<Character, Long> count = new HashMap<>();

            for (int i = 1; i <= 10000; i++) {
                String[] pair = scanner.nextLine().trim().split(" ");
                String erpStr = pair[1];

                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
                    if (index == 0) nonZero.add(c);
                    count.put(c, count.getOrDefault(c, 0L) + 1);
                    alphabet.put(c, false);
                }
            }

            char zeroChar = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZero.contains(c)) {
                    alphabet.put(c, true);
                    zeroChar = c;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);

            for (int i = 1; i <= 9; i++) {
                long minCount = Long.MAX_VALUE;
                char currentChar = zeroChar;

                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) continue;
                    if (count.get(c) < minCount) {
                        minCount = count.get(c);
                        currentChar = c;
                    }
                }

                result.append(currentChar);
                alphabet.put(currentChar, true);
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}