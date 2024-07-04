import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfSlices = scanner.nextInt();
            int d = scanner.nextInt();
            
            boolean hasDouble = false;
            boolean hasTriple = false;
            long maxSlice = 0;
            
            Map<Long, Integer> sliceCounts = new HashMap<>();
            Set<Long> uniqueSlices = new HashSet<>();
            
            for (int i = 0; i < numberOfSlices; i++) {
                long slice = scanner.nextLong();
                uniqueSlices.add(slice);
                maxSlice = Math.max(maxSlice, slice);
                
                sliceCounts.put(slice, sliceCounts.getOrDefault(slice, 0) + 1);
                if (sliceCounts.get(slice) == 2) hasDouble = true;
                if (sliceCounts.get(slice) == 3) hasTriple = true;
            }
            
            int result = 0;
            if (d == 2) {
                if (!hasDouble) result = 1;
            } else {
                if (hasTriple) {
                    result = 0;
                } else {
                    result = 2;
                    for (Map.Entry<Long, Integer> entry : sliceCounts.entrySet()) {
                        if (entry.getValue() == 2 && entry.getKey() != maxSlice) {
                            result = 1;
                            break;
                        }
                        for (long slice : uniqueSlices) {
                            if (slice / 2 == entry.getKey()) {
                                result = 1;
                                break;
                            }
                        }
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}