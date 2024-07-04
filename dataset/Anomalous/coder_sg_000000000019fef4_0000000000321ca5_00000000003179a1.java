import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int u = Integer.parseInt(reader.readLine());
            Map<Integer, Map<Integer, Integer>> digitToCharCountMap = new HashMap<>();
            int[] digitFrequency = new int[10];

            for (int d = 0; d < 10000; d++) {
                Map<Integer, Integer> charCountMap = new HashMap<>();
                for (int c = 0; c < 26; c++) {
                    charCountMap.put(c, 0);
                }
                digitToCharCountMap.put(d, charCountMap);
            }

            for (int q = 0; q < 10; q++) {
                String[] query = reader.readLine().split(" ");
                String message = query[0];
                String response = query[1];

                if (message.length() != response.length()) {
                    continue;
                }

                for (int j = 0; j < message.length(); j++) {
                    int digit = Character.getNumericValue(message.charAt(j));
                    digitFrequency[digit]++;
                    Map<Integer, Integer> charCountMap = digitToCharCountMap.get(digit);
                    int charIndex = response.charAt(j) - 'A';
                    charCountMap.put(charIndex, charCountMap.get(charIndex) + 1);
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int d = 0; d < 10; d++) {
                Map<Integer, Integer> charCountMap = digitToCharCountMap.get(d);
                double maxProbability = 0.0;
                char mostProbableChar = 'A';

                for (int c = 0; c < 26; c++) {
                    double probability = (double) charCountMap.get(c) / digitFrequency[d];
                    if (probability > maxProbability) {
                        maxProbability = probability;
                        mostProbableChar = (char) ('A' + c);
                    }
                }

                answer.append(mostProbableChar);
            }

            result.append("Case #").append(i + 1).append(": ").append(answer).append("\n");
        }

        System.out.print(result);
    }
}