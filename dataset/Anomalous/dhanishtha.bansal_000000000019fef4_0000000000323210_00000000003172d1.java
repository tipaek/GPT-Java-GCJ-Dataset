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
            
            String[] values = br.readLine().trim().split(" ");
            Map<Long, Integer> frequencyMap = new HashMap<>();
            
            long minValue = Long.MAX_VALUE;
            long mostFrequentValue = 0;
            int maxFrequency = 0;
            
            for (String value : values) {
                long val = Long.parseLong(value);
                minValue = Math.min(minValue, val);
                
                frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
                int currentFrequency = frequencyMap.get(val);
                
                if (currentFrequency > maxFrequency) {
                    maxFrequency = currentFrequency;
                    mostFrequentValue = val;
                }
            }
            
            int count = 0;
            
            if (n == 1 && minValue == 1) {
                count = d - 1;
            } else if (maxFrequency == d) {
                count = 0;
            } else {
                d -= maxFrequency;
                Iterator<Map.Entry<Long, Integer>> iterator = frequencyMap.entrySet().iterator();
                
                while (d > 0 && iterator.hasNext()) {
                    Map.Entry<Long, Integer> entry = iterator.next();
                    long key = entry.getKey();
                    
                    while (key > mostFrequentValue && d > 0) {
                        count++;
                        key -= mostFrequentValue;
                        d--;
                    }
                }
                
                if (d > 0) {
                    iterator = frequencyMap.entrySet().iterator();
                    while (d > 0 && iterator.hasNext()) {
                        Map.Entry<Long, Integer> entry = iterator.next();
                        long key = entry.getKey();
                        
                        while (key > minValue && d > 0) {
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