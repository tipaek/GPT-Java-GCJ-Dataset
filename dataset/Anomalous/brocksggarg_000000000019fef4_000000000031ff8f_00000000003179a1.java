import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            solution.solve(i, br);
        }
    }

    private void solve(int t, BufferedReader br) throws NumberFormatException, IOException {
        int u = Integer.parseInt(br.readLine());
        Set<String> uniqueChars = new HashSet<>();
        Map<String, Long> charValueMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            String[] input = br.readLine().split(" ");
            String s = input[1];
            long v = Long.parseLong(input[0]);

            uniqueChars.addAll(Arrays.asList(s.split("")));

            if (v >= 0 && v < 10) {
                charValueMap.put(s, Math.min(charValueMap.getOrDefault(s, 10L), v));
            }
        }

        String[] resultArray = new String[10];
        List<String> remainingChars = new ArrayList<>(uniqueChars);

        for (Map.Entry<String, Long> entry : charValueMap.entrySet()) {
            int index = entry.getValue().intValue();
            if (index < 10) {
                resultArray[index] = entry.getKey();
                remainingChars.remove(entry.getKey());
            }
        }

        int remainingIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (resultArray[i] == null) {
                resultArray[i] = remainingChars.get(remainingIndex++);
            }
        }

        String result = String.join("", resultArray);
        System.out.println("Case #" + t + ": " + result);
    }
}