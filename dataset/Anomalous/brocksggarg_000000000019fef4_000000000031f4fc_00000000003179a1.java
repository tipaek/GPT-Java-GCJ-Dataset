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

    private void solve(int caseNumber, BufferedReader br) throws NumberFormatException, IOException {
        int u = Integer.parseInt(br.readLine());
        Set<String> uniqueChars = new HashSet<>();
        Map<String, Long> charValueMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            String[] input = br.readLine().split(" ");
            long value = Long.parseLong(input[0]);
            String word = input[1];

            for (char c : word.toCharArray()) {
                uniqueChars.add(String.valueOf(c));
            }

            if (value >= 0 && value < 10) {
                charValueMap.put(word, Math.min(charValueMap.getOrDefault(word, 10L), value));
            }
        }

        String[] digits = new String[10];
        for (Map.Entry<String, Long> entry : charValueMap.entrySet()) {
            int index = entry.getValue().intValue();
            if (index < 10) {
                digits[index] = entry.getKey();
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (digits[i] != null) {
                result.append(digits[i]);
                uniqueChars.remove(digits[i]);
            }
        }

        for (String remainingChar : uniqueChars) {
            result.insert(0, remainingChar);
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}