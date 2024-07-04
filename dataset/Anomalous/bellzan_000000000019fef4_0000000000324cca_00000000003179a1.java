import java.io.*;
import java.util.*;

class Solution {
    static int U;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            U = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> frequencyMap = new HashMap<>();
            String[] inputs = new String[10000];
            String[] lettersUsed = new String[9];
            int letterCount = 0;

            for (int j = 0; j < 10000; j++) {
                st = new StringTokenizer(reader.readLine());
                int q = Integer.parseInt(st.nextToken());
                String word = st.nextToken();
                inputs[j] = word;

                String firstChar = Character.toString(word.charAt(0));
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);

                if (frequencyMap.get(firstChar) == 1) {
                    lettersUsed[letterCount++] = firstChar;
                }
            }

            String zeroChar = findZeroChar(inputs, frequencyMap);
            String result = buildResultString(frequencyMap, lettersUsed, letterCount, zeroChar);

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findZeroChar(String[] inputs, HashMap<String, Integer> frequencyMap) {
        for (String word : inputs) {
            for (int l = 1; l < word.length(); l++) {
                String charAtL = Character.toString(word.charAt(l));
                if (!frequencyMap.containsKey(charAtL)) {
                    return charAtL;
                }
            }
        }
        return "";
    }

    private static String buildResultString(HashMap<String, Integer> frequencyMap, String[] lettersUsed, int letterCount, String zeroChar) {
        StringBuilder result = new StringBuilder(zeroChar);

        int[][] frequencyArray = new int[letterCount][2];
        for (int m = 0; m < letterCount; m++) {
            frequencyArray[m][0] = frequencyMap.get(lettersUsed[m]);
            frequencyArray[m][1] = m;
        }

        Arrays.sort(frequencyArray, Comparator.comparingInt(a -> a[0]));

        for (int m = letterCount - 1; m >= 0; m--) {
            result.append(lettersUsed[frequencyArray[m][1]]);
        }

        return result.toString();
    }
}