import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            String[] line = br.readLine().trim().split(" ");
            HashMap<Long, Integer> frequencyMap = new HashMap<>();

            long minValue = Long.MAX_VALUE;
            int maxFrequency = 1;
            long maxFrequencyValue = 0;

            for (int i = 0; i < n; i++) {
                long val = Long.parseLong(line[i]);
                minValue = Math.min(minValue, val);

                frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
                int currentFrequency = frequencyMap.get(val);

                if (currentFrequency > maxFrequency) {
                    maxFrequency = currentFrequency;
                    maxFrequencyValue = val;
                }
            }

            int count = 0;

            if (n == 1 && minValue == 1) {
                count = d - 1;
            } else if (maxFrequency == d) {
                count = 0;
            } else {
                if (maxFrequencyValue > 0) {
                    d -= maxFrequency;
                    for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                        long key = entry.getKey();
                        while (d > 0 && key > maxFrequencyValue) {
                            count++;
                            key -= maxFrequencyValue;
                            d--;
                        }
                    }
                } else {
                    for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                        long key = entry.getKey();
                        while (key > minValue) {
                            count++;
                            key -= minValue;
                            d--;
                        }
                        if (key == minValue) {
                            d--;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + count);
        }
    }
}