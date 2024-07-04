import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int U = scanner.nextInt();
            scanner.nextLine();

            HashMap<Character, Boolean> alphabet = new HashMap<>();
            HashSet<Character> nonZeroCharacters = new HashSet<>();
            HashMap<Character, Long> characterCount = new HashMap<>();

            for (int i = 0; i < 10000; i++) {
                String caseStr = scanner.nextLine();
                String[] pair = caseStr.split(" ");

                int number = Integer.parseInt(pair[0]);
                if (number == -1) continue;

                String erpStr = pair[1];
                for (int j = 0; j < erpStr.length(); j++) {
                    char c = erpStr.charAt(j);
                    if (j == 0) nonZeroCharacters.add(c);
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
                    if (alphabet.get(c)) continue;
                    if (characterCount.get(c) > maxCount) {
                        maxCount = characterCount.get(c);
                        currentCharacter = c;
                    }
                }

                alphabetOrder.append(currentCharacter);
                alphabet.put(currentCharacter, true);
            }

            System.out.println("Case #" + caseIndex + ": " + alphabetOrder);
        }
    }
}