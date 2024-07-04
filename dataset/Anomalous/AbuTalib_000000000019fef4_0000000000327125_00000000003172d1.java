import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            Map<Long, Integer> frequencyMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                long value = scanner.nextLong();
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            }
            
            int minimumSteps = d - 1;
            
            outerLoop:
            for (long key : frequencyMap.keySet()) {
                int count = frequencyMap.get(key);
                int steps = 0;
                
                if (count >= d) {
                    minimumSteps = Math.min(minimumSteps, steps);
                    continue;
                }
                
                TreeSet<Long> divisibleSet = new TreeSet<>();
                TreeSet<Long> nonDivisibleSet = new TreeSet<>();
                
                for (long value : frequencyMap.keySet()) {
                    if (value > key) {
                        if (value % key == 0) {
                            divisibleSet.add(value);
                        } else {
                            nonDivisibleSet.add(value);
                        }
                    }
                }
                
                for (long value : divisibleSet) {
                    long tempValue = value;
                    while (tempValue > key) {
                        if (tempValue == key * 2) {
                            count += 2;
                        } else {
                            count++;
                        }
                        steps++;
                        tempValue -= key;
                        if (count >= d) {
                            minimumSteps = Math.min(minimumSteps, steps);
                            continue outerLoop;
                        }
                    }
                }
                
                for (long value : nonDivisibleSet) {
                    long tempValue = value;
                    while (tempValue > key) {
                        count++;
                        steps++;
                        tempValue -= key;
                        if (count >= d) {
                            minimumSteps = Math.min(minimumSteps, steps);
                            continue outerLoop;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + minimumSteps);
        }
    }
}