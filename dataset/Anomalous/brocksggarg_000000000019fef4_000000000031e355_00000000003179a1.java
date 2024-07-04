import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; i++) {
            solution.processTestCase(i, reader);
        }
    }

    private void processTestCase(int caseNumber, BufferedReader reader) throws NumberFormatException, IOException {
        int u = Integer.parseInt(reader.readLine());
        Set<String> uniqueCharacters = new HashSet<>();
        Map<String, Integer> characterValues = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            String[] input = reader.readLine().split(" ");
            String s = input[1];
            int v = Integer.parseInt(input[0]);

            for (char c : s.toCharArray()) {
                uniqueCharacters.add(String.valueOf(c));
            }

            if (v < 10) {
                characterValues.put(s, Math.min(characterValues.getOrDefault(s, 10), v));
            }
        }

        String[] orderedCharacters = new String[10];

        for (Map.Entry<String, Integer> entry : characterValues.entrySet()) {
            orderedCharacters[entry.getValue()] = entry.getKey();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < 10; i++) {
            if (orderedCharacters[i] != null) {
                result.append(orderedCharacters[i]);
                uniqueCharacters.remove(orderedCharacters[i]);
            }
        }

        for (String remainingCharacter : uniqueCharacters) {
            result.insert(0, remainingCharacter);
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}