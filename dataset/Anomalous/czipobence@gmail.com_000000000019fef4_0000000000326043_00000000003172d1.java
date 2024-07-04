import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            Map<Long, Integer> sliceCountMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                long sliceSize = scanner.nextLong();
                sliceCountMap.put(sliceSize, sliceCountMap.getOrDefault(sliceSize, 0) + 1);
            }
            
            int maxSliceCount = Collections.max(sliceCountMap.values());
            int minCuts = d - 1;
            
            if (maxSliceCount >= d || d == 1) {
                minCuts = 0;
            } else if (d == 2) {
                minCuts = 1;
            } else if (d == 3) {
                boolean hasDoubleSize = false;
                for (long sliceSize : sliceCountMap.keySet()) {
                    for (long otherSliceSize : sliceCountMap.keySet()) {
                        if (sliceSize == 2 * otherSliceSize) {
                            hasDoubleSize = true;
                            break;
                        }
                    }
                    if (hasDoubleSize) break;
                }
                
                if (hasDoubleSize) {
                    minCuts = 1;
                } else {
                    if (maxSliceCount == 1) {
                        minCuts = 2;
                    } else {
                        boolean hasLargerSlice = false;
                        for (long sliceSize : sliceCountMap.keySet()) {
                            if (sliceCountMap.get(sliceSize) > 1) {
                                for (long otherSliceSize : sliceCountMap.keySet()) {
                                    if (sliceSize < otherSliceSize) {
                                        hasLargerSlice = true;
                                        break;
                                    }
                                }
                                if (hasLargerSlice) break;
                            }
                        }
                        if (hasLargerSlice) {
                            minCuts = 1;
                        } else {
                            minCuts = 2;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + minCuts);
        }
    }
}