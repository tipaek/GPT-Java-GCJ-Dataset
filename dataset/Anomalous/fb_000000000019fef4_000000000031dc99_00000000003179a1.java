import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        Map<Character, Integer> characterFrequency = new TreeMap<>();
        int U = scanner.nextInt();

        for (int i = 0; i < 1000; i++) {
            int Q = scanner.nextInt();
            String response = scanner.next();
            char firstChar = response.charAt(0);

            for (char c : response.toCharArray()) {
                characterFrequency.putIfAbsent(c, 0);
            }

            characterFrequency.put(firstChar, characterFrequency.get(firstChar) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char mostFrequentChar = '?';
            int highestFrequency = -1;

            for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    mostFrequentChar = entry.getKey();
                    highestFrequency = entry.getValue();
                }
            }

            result.append(mostFrequentChar);
            characterFrequency.remove(mostFrequentChar);
        }

        result.insert(0, result.charAt(result.length() - 1));
        result.setLength(result.length() - 1);

        System.out.println("Case #" + caseId + ": " + result);
    }
}