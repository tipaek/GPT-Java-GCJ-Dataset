import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            solve(i + 1, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        Map<Character, Integer> frequencyMap = new TreeMap<>();
        int U = scanner.nextInt();

        for (int i = 0; i < 10000; i++) {
            int Q = scanner.nextInt();
            String response = scanner.next();
            char firstChar = response.charAt(0);

            for (char c : response.toCharArray()) {
                frequencyMap.putIfAbsent(c, 0);
            }

            frequencyMap.put(firstChar, frequencyMap.get(firstChar) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char mostFrequentChar = '?';
            int highestFrequency = -1;

            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    mostFrequentChar = entry.getKey();
                    highestFrequency = entry.getValue();
                }
            }

            result.append(mostFrequentChar);
            frequencyMap.remove(mostFrequentChar);
        }

        result.insert(0, result.charAt(result.length() - 1));
        result.setLength(result.length() - 1);

        System.out.println("Case #" + caseId + ": " + result);
    }
}