import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            new Solution().solve(i, br);
        }
    }

    private void solve(int t, BufferedReader br) throws NumberFormatException, IOException {
        int u = Integer.parseInt(br.readLine());
        Set<String> uniqueChars = new HashSet<>();
        Map<String, Integer> charToValue = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            String[] input = br.readLine().split(" ");
            String s = input[1];
            int value = Integer.parseInt(input[0]);

            for (char c : s.toCharArray()) {
                uniqueChars.add(String.valueOf(c));
            }

            if (value >= 0 && value < 10) {
                charToValue.put(s, Math.min(charToValue.getOrDefault(s, 10), value));
            }
        }

        String[] resultArray = new String[10];
        for (Map.Entry<String, Integer> entry : charToValue.entrySet()) {
            resultArray[entry.getValue()] = entry.getKey();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (resultArray[i] != null) {
                result.append(resultArray[i]);
                uniqueChars.remove(resultArray[i]);
            }
        }

        for (String remainingChar : uniqueChars) {
            result.insert(0, remainingChar);
        }

        System.out.println("Case #" + t + ": " + result);
    }
}