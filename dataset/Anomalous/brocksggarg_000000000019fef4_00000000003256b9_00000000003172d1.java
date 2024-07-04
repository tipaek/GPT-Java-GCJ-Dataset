import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            solution.solve(i, br);
        }
    }

    private void solve(int t, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        
        String[] numbers = br.readLine().split(" ");
        List<Long> values = new ArrayList<>();
        Map<Long, Integer> frequencyMap = new HashMap<>();
        
        for (String number : numbers) {
            long value = Long.parseLong(number);
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        
        int maxFrequency = 0;
        for (long key : frequencyMap.keySet()) {
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(key));
            values.add(key);
        }
        
        Collections.sort(values);
        int result = determineResult(d, maxFrequency, values);
        
        System.out.println("Case #" + t + ": " + result);
    }

    private int determineResult(int d, int maxFrequency, List<Long> values) {
        if (d == 2) {
            return maxFrequency >= 2 ? 0 : 1;
        } else {
            if (maxFrequency >= 3) {
                return 0;
            } else if (maxFrequency >= 2) {
                return 1;
            } else {
                return checkPairs(values);
            }
        }
    }

    private int checkPairs(List<Long> values) {
        int size = values.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (values.get(i) * 2 == values.get(j)) {
                    return 1;
                }
            }
        }
        return 2;
    }
}