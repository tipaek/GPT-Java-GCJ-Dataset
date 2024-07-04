import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int u = Integer.parseInt(reader.readLine());
            Map<Integer, Map<Integer, Integer>> frequencyMap = new HashMap<>();
            int[] digitTotal = new int[10];

            for (int digit = 0; digit < 10; digit++) {
                Map<Integer, Integer> charFrequency = new HashMap<>();
                for (int charIndex = 0; charIndex < 26; charIndex++) {
                    charFrequency.put(charIndex, 0);
                }
                frequencyMap.put(digit, charFrequency);
            }

            for (int j = 0; j < 10000; j++) {
                String[] query = reader.readLine().split(" ");
                String message = query[0];
                String response = query[1];

                if (message.length() != response.length()) {
                    continue;
                }

                boolean[] digitVisited = new boolean[10];
                for (int k = 0; k < message.length(); k++) {
                    int digit = Character.getNumericValue(message.charAt(k));
                    if (digitVisited[digit]) {
                        continue;
                    }
                    digitTotal[digit]++;
                    Map<Integer, Integer> charFrequency = frequencyMap.get(digit);
                    int charIndex = response.charAt(k) - 'A';
                    charFrequency.put(charIndex, charFrequency.get(charIndex) + 1);
                    frequencyMap.put(digit, charFrequency);
                    digitVisited[digit] = true;
                }
            }

            StringBuilder answerBuilder = new StringBuilder();
            boolean[] charTaken = new boolean[26];

            for (int digit = 0; digit < 10; digit++) {
                Map<Integer, Integer> charFrequency = frequencyMap.get(digit);
                double maxProbability = 0.0;
                char selectedChar = 'A';

                for (int charIndex = 0; charIndex < 26; charIndex++) {
                    if (charTaken[charIndex]) {
                        continue;
                    }
                    double probability = (double) charFrequency.get(charIndex) / digitTotal[digit];
                    if (probability > maxProbability) {
                        maxProbability = probability;
                        selectedChar = (char) ('A' + charIndex);
                    }
                }

                charTaken[selectedChar - 'A'] = true;
                answerBuilder.append(selectedChar);
            }

            resultBuilder.append("Case #").append(i + 1).append(": ").append(answerBuilder).append("\n");
        }

        System.out.print(resultBuilder);
    }
}