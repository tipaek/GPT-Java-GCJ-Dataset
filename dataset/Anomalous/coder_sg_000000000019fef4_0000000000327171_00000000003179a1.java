import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int u = Integer.parseInt(reader.readLine());
            Map<Integer, Map<Integer, Integer>> digitToCharCountMap = new HashMap<>();
            int[] totalCounts = new int[10];

            initializeMaps(digitToCharCountMap);

            for (int query = 0; query < 10000; query++) {
                String[] queryInput = reader.readLine().split(" ");
                String message = queryInput[0];
                String response = queryInput[1];

                if (message.length() != response.length()) {
                    continue;
                }

                Map<Integer, Integer> visitedDigits = new HashMap<>();
                processQuery(message, response, totalCounts, digitToCharCountMap, visitedDigits);
            }

            StringBuilder answer = new StringBuilder();
            boolean[] usedCharacters = new boolean[26];

            constructAnswer(digitToCharCountMap, totalCounts, answer, usedCharacters);

            resultBuilder.append("Case #").append(testCase + 1).append(": ").append(answer).append("\n");
        }
        System.out.print(resultBuilder);
    }

    private static void initializeMaps(Map<Integer, Map<Integer, Integer>> digitToCharCountMap) {
        for (int digit = 0; digit < 10; digit++) {
            Map<Integer, Integer> charCountMap = new HashMap<>();
            for (int character = 0; character < 26; character++) {
                charCountMap.put(character, 0);
            }
            digitToCharCountMap.put(digit, charCountMap);
        }
    }

    private static void processQuery(String message, String response, int[] totalCounts,
                                     Map<Integer, Map<Integer, Integer>> digitToCharCountMap,
                                     Map<Integer, Integer> visitedDigits) {
        for (int index = 0; index < message.length(); index++) {
            int digit = Character.getNumericValue(message.charAt(index));
            int character = response.charAt(index) - 'A';

            if (visitedDigits.containsKey(digit)) {
                if (visitedDigits.get(digit) != character) {
                    totalCounts[digit]--;
                    updateCharCountMap(digitToCharCountMap, digit, character, -1);
                }
            } else {
                totalCounts[digit]++;
                updateCharCountMap(digitToCharCountMap, digit, character, 1);
                visitedDigits.put(digit, character);
            }
        }
    }

    private static void updateCharCountMap(Map<Integer, Map<Integer, Integer>> digitToCharCountMap,
                                           int digit, int character, int count) {
        Map<Integer, Integer> charCountMap = digitToCharCountMap.get(digit);
        charCountMap.put(character, charCountMap.get(character) + count);
    }

    private static void constructAnswer(Map<Integer, Map<Integer, Integer>> digitToCharCountMap,
                                        int[] totalCounts, StringBuilder answer, boolean[] usedCharacters) {
        for (int digit = 0; digit < 10; digit++) {
            Map<Integer, Integer> charCountMap = digitToCharCountMap.get(digit);
            double maxProbability = 0.0;
            char bestCharacter = 'A';

            for (int character = 0; character < 26; character++) {
                if (usedCharacters[character]) {
                    continue;
                }

                double probability = charCountMap.get(character) / (double) totalCounts[digit];
                if (probability > maxProbability) {
                    maxProbability = probability;
                    bestCharacter = (char) ('A' + character);
                }
            }

            usedCharacters[bestCharacter - 'A'] = true;
            answer.append(bestCharacter);
        }
    }
}