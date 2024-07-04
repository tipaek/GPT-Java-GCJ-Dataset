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
            Map<Integer, Map<Integer, Integer>> digitToCharFrequency = new HashMap<>();
            int[] digitTotal = new int[10];

            for (int digit = 0; digit < 10; digit++) {
                Map<Integer, Integer> charFrequency = new HashMap<>();
                for (int charIndex = 0; charIndex < 26; charIndex++) {
                    charFrequency.put(charIndex, 0);
                }
                digitToCharFrequency.put(digit, charFrequency);
            }

            for (int queryIndex = 0; queryIndex < 10000; queryIndex++) {
                String[] query = reader.readLine().split(" ");
                String message = query[0];
                String response = query[1];

                if (message.length() != response.length()) {
                    continue;
                }

                for (int charIndex = 0; charIndex < message.length(); charIndex++) {
                    char messageChar = message.charAt(charIndex);
                    int digit = Character.getNumericValue(messageChar);
                    digitTotal[digit]++;

                    Map<Integer, Integer> charFrequency = digitToCharFrequency.get(digit);
                    char responseChar = response.charAt(charIndex);
                    int responseCharIndex = responseChar - 'A';
                    charFrequency.put(responseCharIndex, charFrequency.get(responseCharIndex) + 1);
                }
            }

            StringBuilder caseResult = new StringBuilder();
            boolean[] usedChars = new boolean[26];

            for (int digit = 0; digit < 10; digit++) {
                Map<Integer, Integer> charFrequency = digitToCharFrequency.get(digit);
                double highestFrequency = 0.0;
                char mostFrequentChar = 'A';

                for (int charIndex = 0; charIndex < 26; charIndex++) {
                    if (usedChars[charIndex]) {
                        continue;
                    }

                    double frequency = charFrequency.get(charIndex) / (double) digitTotal[digit];
                    if (frequency > highestFrequency) {
                        highestFrequency = frequency;
                        mostFrequentChar = (char) ('A' + charIndex);
                    }
                }
                usedChars[mostFrequentChar - 'A'] = true;
                caseResult.append(mostFrequentChar);
            }

            resultBuilder.append("Case #").append(testCase + 1).append(": ").append(caseResult).append("\n");
        }
        System.out.print(resultBuilder);
    }
}