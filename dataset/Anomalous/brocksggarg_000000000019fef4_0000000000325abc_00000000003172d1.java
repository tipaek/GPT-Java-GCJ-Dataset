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

    private void solve(int caseNumber, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        List<Long> values = new ArrayList<>();
        Map<Long, Integer> frequencyMap = new HashMap<>();

        for (String s : input) {
            long value = Long.parseLong(s);
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        int maxFrequency = 0;
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            maxFrequency = Math.max(maxFrequency, entry.getValue());
            values.add(entry.getKey());
        }

        Collections.sort(values);
        int uniqueValuesCount = values.size();
        int result = 0;

        if (d == 2) {
            result = (maxFrequency >= 2) ? 0 : 1;
        } else {
            if (maxFrequency >= 3) {
                result = 0;
            } else {
                result = 2;
                for (int i = 0; i < uniqueValuesCount - 1; i++) {
                    if (frequencyMap.get(values.get(i)) >= 2) {
                        result = 1;
                        break;
                    }
                }

                outerLoop:
                for (int i = 0; i < uniqueValuesCount - 1; i++) {
                    for (int j = i + 1; j < uniqueValuesCount; j++) {
                        if (values.get(i) * 2 == values.get(j)) {
                            result = 1;
                            break outerLoop;
                        }
                    }
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}