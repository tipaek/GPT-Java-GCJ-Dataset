import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(System.getProperty("user.dir") + "/src/sample.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int u = sc.nextInt();
            String[] r = new String[10000];
            for (int j = 0; j < 10000; j++) {
                sc.nextLong();
                r[j] = sc.nextLine().trim();
            }
            System.out.println("Case #" + i + ": " + solve(r, u));
        }
        sc.close();
    }

    private static String solve(String[] r, int u) {
        Map<Character, Long> frequencyMap = new HashMap<>();
        for (String s : r) {
            if (u == 16 && s.length() < 16) continue;
            char firstChar = s.charAt(0);
            frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0L) + 1);
        }

        for (String s : r) {
            for (char c : s.toCharArray()) {
                if (!frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, 0L);
                    break;
                }
            }
        }

        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            char minChar = '\0';
            long minValue = Long.MAX_VALUE;
            for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {
                if (entry.getValue() < minValue) {
                    minValue = entry.getValue();
                    minChar = entry.getKey();
                }
            }
            result[i] = minChar;
            frequencyMap.remove(minChar);
        }

        return new String(result);
    }
}