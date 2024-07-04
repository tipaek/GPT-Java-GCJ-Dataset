import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        processCases(scanner);
    }

    public static void processCases(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabetPresence = new HashMap<>();
            Set<Character> nonZeroCharacters = new HashSet<>();
            Map<Character, Long> characterFrequency = new HashMap<>();

            for (int i = 1; i <= 10000; i++) {
                String inputLine = scanner.nextLine().trim();
                String[] parts = inputLine.split(" ");
                String erpString = parts[1];

                for (int j = 0; j < erpString.length(); j++) {
                    char currentChar = erpString.charAt(j);
                    if (j == 0) nonZeroCharacters.add(currentChar);
                    characterFrequency.put(currentChar, characterFrequency.getOrDefault(currentChar, 0L) + 1);
                    alphabetPresence.put(currentChar, false);
                }
            }

            char zeroChar = 'a';
            for (Character character : alphabetPresence.keySet()) {
                if (!nonZeroCharacters.contains(character)) {
                    alphabetPresence.put(character, true);
                    zeroChar = character;
                }
            }

            StringBuilder alphabetOrder = new StringBuilder().append(zeroChar);
            for (int i = 1; i <= 9; i++) {
                long minFrequency = Long.MAX_VALUE;
                char nextChar = zeroChar;

                for (Character character : alphabetPresence.keySet()) {
                    if (alphabetPresence.get(character)) continue;
                    long currentFrequency = characterFrequency.getOrDefault(character, Long.MAX_VALUE);
                    if (currentFrequency < minFrequency) {
                        minFrequency = currentFrequency;
                        nextChar = character;
                    }
                }

                alphabetOrder.append(nextChar);
                alphabetPresence.put(nextChar, true);
            }

            System.out.println("Case #" + caseIndex + ": " + alphabetOrder);
        }
    }
}