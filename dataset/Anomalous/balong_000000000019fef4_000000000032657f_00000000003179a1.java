import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZero = new HashSet<>();
            Map<Character, Long> count = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine();
                String[] pair = caseStr.split(" ");

                int number = Integer.parseInt(pair[0]);
                if (number == -1) continue;

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

            StringBuilder alphabetOrder = new StringBuilder().append(zeroChar);
            for (int i = 1; i <= 9; i++) {
                long maxCount = 0;
                char currentChar = zeroChar;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) {
                        continue;
                    }
                    if (count.getOrDefault(c, 0L) > maxCount) {
                        maxCount = count.get(c);
                        currentChar = c;
                    }
                }
                alphabetOrder.append(currentChar);
                alphabet.put(currentChar, true);
            }
            System.out.println("Case #" + caseNum + ": " + alphabetOrder.toString());
        }
    }
}