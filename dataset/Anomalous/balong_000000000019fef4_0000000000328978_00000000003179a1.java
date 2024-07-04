import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        processCases(scanner);
    }

    private static void processCases(Scanner scanner) {
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int U = Integer.parseInt(scanner.nextLine());
            Map<Character, Boolean> alphabetMap = new HashMap<>();
            Set<Character> nonZeroSet = new HashSet<>();
            Map<Character, Long> frequencyMap = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String inputLine = scanner.nextLine().trim();
                String[] parts = inputLine.split(" ");
                String erpString = parts[1];

                for (int index = 0; index < erpString.length(); index++) {
                    char character = erpString.charAt(index);
                    if (index == 0) nonZeroSet.add(character);
                    frequencyMap.put(character, frequencyMap.getOrDefault(character, 0L) + 1);
                    alphabetMap.put(character, false);
                }
            }

            char zeroCharacter = 'a';
            for (Character character : alphabetMap.keySet()) {
                if (!nonZeroSet.contains(character)) {
                    alphabetMap.put(character, true);
                    zeroCharacter = character;
                }
            }

            StringBuilder result = new StringBuilder().append(zeroCharacter);
            for (int i = 1; i <= 9; i++) {
                long maxFrequency = Long.MIN_VALUE;
                char currentCharacter = zeroCharacter;

                for (Character character : alphabetMap.keySet()) {
                    if (alphabetMap.get(character)) continue;
                    if (frequencyMap.get(character) > maxFrequency) {
                        maxFrequency = frequencyMap.get(character);
                        currentCharacter = character;
                    }
                }
                result.append(currentCharacter);
                alphabetMap.put(currentCharacter, true);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}