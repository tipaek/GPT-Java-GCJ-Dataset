import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZero = new HashSet<>();
            Map<Character, Long> count = new HashMap<>();

            for (int i = 1; i <= 10000; i++) {
                String caseStr = scanner.nextLine().trim();
                String[] pair = caseStr.split(" ");
                String erpStr = pair[1];

                char firstChar = erpStr.charAt(0);
                nonZero.add(firstChar);
                count.put(firstChar, count.getOrDefault(firstChar, 0L) + 1);
                alphabet.put(firstChar, false);
            }

            char zeroChar = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZero.contains(c)) {
                    alphabet.put(c, true);
                    zeroChar = c;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);

            for (int i = 1; i <= 9; i++) {
                long maxCount = Long.MIN_VALUE;
                char maxChar = zeroChar;

                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) continue;
                    long charCount = count.getOrDefault(c, 0L);
                    if (charCount > maxCount) {
                        maxCount = charCount;
                        maxChar = c;
                    }
                }

                result.append(maxChar);
                alphabet.put(maxChar, true);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}