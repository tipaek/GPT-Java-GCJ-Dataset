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
            scanner.nextLine();  // Skip the line as in the original code

            HashMap<Character, Boolean> alphabet = new HashMap<>();
            HashSet<Character> nonZeroCharacters = new HashSet<>();
            HashMap<Character, Long> characterCount = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine();
                String[] pair = caseStr.split(" ");

                int number = Integer.parseInt(pair[0]);
                if (number == -1) continue;

                String erpStr = pair[1];
                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
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

            StringBuilder result = new StringBuilder();
            result.append(zeroCharacter);
            for (int i = 1; i <= 9; i++) {
                long maxCount = 0;
                char currentCharacter = zeroCharacter;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) continue;
                    if (characterCount.getOrDefault(c, 0L) > maxCount) {
                        maxCount = characterCount.get(c);
                        currentCharacter = c;
                    }
                }
                result.append(currentCharacter);
                alphabet.put(currentCharacter, true);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}