import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int U = scanner.nextInt();
            scanner.nextLine();

            Map<Character, Boolean> alphabet = new HashMap<>();
            Set<Character> nonZeroCharacters = new HashSet<>();
            Map<Character, Integer> characterCount = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine();
                String[] pair = caseStr.split(" ");

                int number = Integer.parseInt(pair[0]);
                if (number == -1) continue;

                String erpStr = pair[1];
                for (int index = 0; index < erpStr.length(); index++) {
                    char c = erpStr.charAt(index);
                    if (index == 0) nonZeroCharacters.add(c);
                    characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
                    alphabet.put(c, false);
                }
            }

            char zeroCharacter = 'a';
            for (Character c : alphabet.keySet()) {
                if (!nonZeroCharacters.contains(c)) {
                    alphabet.put(c, true);
                    zeroCharacter = c;
                    characterCount.put(c, 0);
                }
            }

            StringBuilder alphabetOrder = new StringBuilder().append(zeroCharacter);
            for (int i = 1; i <= 9; i++) {
                int maxCount = 0;
                char currentChar = zeroCharacter;
                for (Character c : alphabet.keySet()) {
                    if (alphabet.get(c)) continue;
                    if (characterCount.get(c) > maxCount) {
                        maxCount = characterCount.get(c);
                        currentChar = c;
                    }
                }
                alphabetOrder.append(currentChar);
                alphabet.put(currentChar, true);
            }

            System.out.println("Case #" + caseNumber + ": " + alphabetOrder);
        }
    }
}