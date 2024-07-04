import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZeroCharacters = new HashSet<>();
            Map<Character, Long> characterCount = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String inputLine = scanner.nextLine().trim();
                if (inputLine == null || inputLine.isEmpty() || inputLine.equals("-1")) {
                    continue;
                }

                String[] parts = inputLine.split(" ");
                long number = Long.parseLong(parts[0]);
                if (number == -1) {
                    continue;
                }

                String erpString = parts[1];
                for (int index = 0; index < erpString.length(); index++) {
                    char c = erpString.charAt(index);
                    if (index == 0) nonZeroCharacters.add(c);
                    characterCount.put(c, characterCount.getOrDefault(c, 0L) + 1);
                    alphabet.put(c, false);
                }
            }

            char zeroCharacter = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZeroCharacters.contains(c)) {
                    alphabet.put(c, true);
                    zeroCharacter = c;
                }
            }

            StringBuilder alphabetOrder = new StringBuilder().append(zeroCharacter);
            for (int i = 1; i <= 9; i++) {
                long maxCount = 0;
                char currentCharacter = zeroCharacter;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) {
                        continue;
                    }
                    if (characterCount.get(c) > maxCount) {
                        maxCount = characterCount.get(c);
                        currentCharacter = c;
                    }
                }
                alphabetOrder.append(currentCharacter);
                alphabet.put(currentCharacter, true);
            }
            System.out.println("Case #" + caseNumber + ": " + alphabetOrder);
        }
    }
}