import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        final int NUM_LINES = 10000;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 0; t < testCases; t++) {
            int u = Integer.parseInt(reader.readLine());

            Set<Character> uniqueLetters = new TreeSet<>();
            Map<Character, Integer> frequencyMap = new TreeMap<>();
            for (int i = 0; i < NUM_LINES; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int q = Integer.parseInt(tokenizer.nextToken());
                String r = tokenizer.nextToken();
                char firstChar = r.charAt(0);
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
                for (char c : r.toCharArray()) {
                    uniqueLetters.add(c);
                }
            }

            for (char c : uniqueLetters) {
                frequencyMap.putIfAbsent(c, 0);
            }

            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            if (sortedEntries.size() != 10) {
                throw new IllegalStateException("Expected exactly 10 unique characters");
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                resultBuilder.append(entry.getKey());
            }

            String result = resultBuilder.charAt(0) + resultBuilder.reverse().substring(0, 9);
            writer.printf("Case #%d: %s\n", t + 1, result);
        }

        reader.close();
        writer.close();
    }
}