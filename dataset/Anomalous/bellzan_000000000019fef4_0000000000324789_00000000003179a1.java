import java.io.*;
import java.util.*;

class Solution {
    static int U;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            U = Integer.parseInt(reader.readLine().trim());
            Map<String, Integer> frequencyMap = new HashMap<>();
            String[] inputs = new String[10000];
            Set<String> uniqueLetters = new HashSet<>();
            String zeroChar = "";
            StringBuilder answer = new StringBuilder();

            for (int j = 0; j < 10000; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int q = Integer.parseInt(st.nextToken());
                String word = st.nextToken();
                inputs[j] = word;

                String firstChar = String.valueOf(word.charAt(0));
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
                uniqueLetters.add(firstChar);
            }

            outerLoop:
            for (String word : inputs) {
                for (int l = 1; l < word.length(); l++) {
                    String currentChar = String.valueOf(word.charAt(l));
                    if (!frequencyMap.containsKey(currentChar)) {
                        zeroChar = currentChar;
                        break outerLoop;
                    }
                }
            }

            answer.append(zeroChar);

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            for (int m = sortedEntries.size() - 1; m >= 0; m--) {
                answer.append(sortedEntries.get(m).getKey());
            }

            System.out.println("Case #" + (i + 1) + ": " + answer.toString());
        }
    }
}