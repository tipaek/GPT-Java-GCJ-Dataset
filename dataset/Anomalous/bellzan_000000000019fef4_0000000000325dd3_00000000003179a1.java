import java.io.*;
import java.util.*;

public class Solution {
    static int U;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            U = Integer.parseInt(st.nextToken());

            Map<String, Integer> charFrequency = new HashMap<>();
            String[] inputs = new String[10000];
            Set<String> uniqueChars = new HashSet<>();
            String zeroChar = "";
            StringBuilder answer = new StringBuilder();
            boolean foundZero = false;

            for (int j = 0; j < 10000; j++) {
                st = new StringTokenizer(reader.readLine());
                long q = Long.parseLong(st.nextToken());
                String query = st.nextToken();
                inputs[j] = query;

                String firstChar = query.substring(0, 1);
                charFrequency.put(firstChar, charFrequency.getOrDefault(firstChar, 0) + 1);
                uniqueChars.add(firstChar);
            }

            for (int k = 0; k < 10000 && !foundZero; k++) {
                String current = inputs[k];
                for (int l = 1; l < current.length(); l++) {
                    String charAtL = current.substring(l, l + 1);
                    if (!charFrequency.containsKey(charAtL)) {
                        foundZero = true;
                        zeroChar = charAtL;
                        break;
                    }
                }
            }

            answer.append(zeroChar);

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(charFrequency.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            for (Map.Entry<String, Integer> entry : sortedEntries) {
                answer.append(entry.getKey());
            }

            System.out.println("Case #" + (i + 1) + ": " + answer.toString());
        }
    }
}