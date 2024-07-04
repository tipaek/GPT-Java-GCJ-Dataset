import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZero = new HashSet<>();
            Map<Character, Long> count = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine().trim();
                if (caseStr.isEmpty() || caseStr.equals("-1")) {
                    continue;
                }
                String[] pair = caseStr.split(" ");
                long number = Long.parseLong(pair[0]);
                if (number == -1) {
                    continue;
                }
                
                String erpStr = pair[1];
                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
                    if (index == 0) nonZero.add(c);
                    count.put(c, count.getOrDefault(c, 0L) + 1);
                    alphabet.put(c, false);
                }
            }

            char zero = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZero.contains(c)) {
                    alphabet.put(c, true);
                    zero = c;
                }
            }

            StringBuilder alp = new StringBuilder().append(zero);
            for (int i = 1; i <= 9; i++) {
                long maxCount = 0;
                char currentChar = zero;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) {
                        continue;
                    }
                    if (count.get(c) > maxCount) {
                        maxCount = count.get(c);
                        currentChar = c;
                    }
                }
                alp.append(currentChar);
                alphabet.put(currentChar, true);
            }
            System.out.println("Case #" + caseNumber + ": " + alp);
        }
    }
}