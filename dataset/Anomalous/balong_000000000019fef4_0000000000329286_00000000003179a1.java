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
                String[] input = scanner.nextLine().trim().split(" ");
                String erpStr = input[1];

                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
                    if (index == 0) {
                        nonZeroCharacters.add(c);
                    }
                    characterCount.put(c, characterCount.getOrDefault(c, 0L) + 1);
                    alphabet.put(c, false);
                }
            }

            char zeroCharacter = 'a';
            for (char c : alphabet.keySet()) {
                if (!nonZeroCharacters.contains(c)) {
                    alphabet.put(c, true);
                    zeroCharacter = c;
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroCharacter);

            for (int i = 1; i <= 9; i++) {
                long minCount = Long.MAX_VALUE;
                char currentCharacter = zeroCharacter;

                for (char c : alphabet.keySet()) {
                    if (alphabet.get(c)) {
                        continue;
                    }
                    if (characterCount.get(c) < minCount) {
                        minCount = characterCount.get(c);
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