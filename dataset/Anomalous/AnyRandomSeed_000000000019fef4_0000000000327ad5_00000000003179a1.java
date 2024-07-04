import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(System.getProperty("user.dir") + "/src/" + "sample.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = sc.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int u = sc.nextInt();
                String[] responses = new String[10000];
                for (int j = 0; j < 10000; j++) {
                    sc.nextLong(); // consume the long input
                    responses[j] = sc.nextLine().trim();
                }
                Solution solution = new Solution();
                System.out.println("Case #" + i + ": " + solution.solve(responses, u));
            }
        }
    }

    private String solve(String[] responses, int u) {
        Map<Character, Long> frequencyMap = new HashMap<>();
        for (String response : responses) {
            if (u == 16 && response.length() < 16) {
                continue;
            }
            for (char ch : response.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0L) + 1);
            }
        }

        char[] result = new char[10];
        long minFrequency = Long.MAX_VALUE;

        // Find the character with the minimum frequency for the first position
        for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                result[0] = entry.getKey();
            }
        }
        frequencyMap.remove(result[0]);

        // Find the characters with the next minimum frequencies for the remaining positions
        for (int i = 9; i >= 1; i--) {
            minFrequency = Long.MAX_VALUE;
            for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {
                if (entry.getValue() < minFrequency) {
                    minFrequency = entry.getValue();
                    result[i] = entry.getKey();
                }
            }
            frequencyMap.remove(result[i]);
        }

        return new String(result);
    }
}