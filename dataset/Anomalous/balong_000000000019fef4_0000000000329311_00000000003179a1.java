import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZero = new HashSet<>();
            Map<Character, Long> count = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine().trim();
                String[] pair = caseStr.split(" ");
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

            StringBuilder alp = new StringBuilder().append(zeroChar);
            for (int i = 1; i <= 9; i++) {
                long maxCount = Long.MIN_VALUE;
                char currentChar = zeroChar;

                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) continue;
                    if (count.get(c) > maxCount) {
                        maxCount = count.get(c);
                        currentChar = c;
                    }
                }

                alp.append(currentChar);
                alphabet.put(currentChar, true);
            }

            System.out.println("Case #" + caseIndex + ": " + alp);
        }
    }
}