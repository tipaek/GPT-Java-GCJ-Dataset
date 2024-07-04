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
            Map<Integer, Map<Integer, Integer>> digitCharCountMap = initializeDigitCharCountMap();
            int[] totalCounts = new int[10];

            processQueries(reader, digitCharCountMap, totalCounts);

            StringBuilder caseResult = new StringBuilder();
            boolean[] isCharTaken = new boolean[26];
            determineCharacterMapping(digitCharCountMap, totalCounts, caseResult, isCharTaken);

            resultBuilder.append("Case #").append(i + 1).append(": ").append(caseResult).append("\n");
        }

        System.out.print(resultBuilder);
    }

    private static Map<Integer, Map<Integer, Integer>> initializeDigitCharCountMap() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int d = 0; d < 10; d++) {
            Map<Integer, Integer> charCountMap = new HashMap<>();
            for (int c = 0; c < 26; c++) {
                charCountMap.put(c, 0);
            }
            map.put(d, charCountMap);
        }
        return map;
    }

    private static void processQueries(BufferedReader reader, Map<Integer, Map<Integer, Integer>> digitCharCountMap, int[] totalCounts) throws IOException {
        for (int q = 0; q < 10000; q++) {
            String[] query = reader.readLine().split(" ");
            String number = query[0];
            String response = query[1];
            Map<Integer, Integer> visitedDigits = new HashMap<>();

            updateCountMaps(number, response, digitCharCountMap, totalCounts, visitedDigits);
        }
    }

    private static void updateCountMaps(String number, String response, Map<Integer, Map<Integer, Integer>> digitCharCountMap, int[] totalCounts, Map<Integer, Integer> visitedDigits) {
        for (int j = 0; j < number.length() && j < response.length(); j++) {
            int digit = Character.getNumericValue(number.charAt(j));
            int charIndex = response.charAt(j) - 'A';

            if (visitedDigits.containsKey(digit)) {
                updateExistingDigit(digitCharCountMap, totalCounts, visitedDigits, digit, charIndex);
            } else {
                updateNewDigit(digitCharCountMap, totalCounts, visitedDigits, digit, charIndex);
            }
        }
    }

    private static void updateExistingDigit(Map<Integer, Map<Integer, Integer>> digitCharCountMap, int[] totalCounts, Map<Integer, Integer> visitedDigits, int digit, int charIndex) {
        if (!visitedDigits.get(digit).equals(charIndex)) {
            totalCounts[digit]--;
            digitCharCountMap.get(digit).put(charIndex, digitCharCountMap.get(digit).get(charIndex) - 1);
        } else {
            totalCounts[digit]++;
            digitCharCountMap.get(digit).put(charIndex, digitCharCountMap.get(digit).get(charIndex) + 1);
        }
    }

    private static void updateNewDigit(Map<Integer, Map<Integer, Integer>> digitCharCountMap, int[] totalCounts, Map<Integer, Integer> visitedDigits, int digit, int charIndex) {
        totalCounts[digit]++;
        digitCharCountMap.get(digit).put(charIndex, digitCharCountMap.get(digit).get(charIndex) + 1);
        visitedDigits.put(digit, charIndex);
    }

    private static void determineCharacterMapping(Map<Integer, Map<Integer, Integer>> digitCharCountMap, int[] totalCounts, StringBuilder caseResult, boolean[] isCharTaken) {
        for (int d = 0; d < 10; d++) {
            Map<Integer, Integer> charCountMap = digitCharCountMap.get(d);
            double maxProbability = 0.0;
            char bestChar = 'A';

            for (int c = 0; c < 26; c++) {
                if (isCharTaken[c]) continue;

                double probability = charCountMap.get(c) / (double) totalCounts[d];
                if (probability > maxProbability) {
                    maxProbability = probability;
                    bestChar = (char) ('A' + c);
                }
            }

            isCharTaken[bestChar - 'A'] = true;
            caseResult.append(bestChar);
        }
    }
}