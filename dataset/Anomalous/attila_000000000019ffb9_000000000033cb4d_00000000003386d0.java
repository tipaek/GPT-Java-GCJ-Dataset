import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            Map<Integer, Integer> rowCounts = new HashMap<>();
            Map<Integer, Integer> colCounts = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String[] coordinates = reader.readLine().split(" ");
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);
                rowCounts.merge(row, 1, Integer::sum);
                colCounts.merge(col, 1, Integer::sum);
            }
            
            int maxRowCount = computeMaxCount(rowCounts);
            int maxColCount = computeMaxCount(colCounts);
            
            System.out.println("Case #" + testCase + ": " + Math.max(maxRowCount, maxColCount));
        }
    }

    private static int computeMaxCount(Map<Integer, Integer> countMap) {
        int totalSum = 0;
        int oddCount = 0;
        int singleCount = 0;
        
        for (int count : countMap.values()) {
            if (count == 1) {
                singleCount++;
            } else if (count % 2 == 0) {
                totalSum += count;
            } else {
                totalSum += count - 1;
                oddCount++;
            }
        }
        
        if (oddCount % 2 == 1) {
            oddCount--;
        }
        
        return totalSum + Math.min(singleCount, 2) + oddCount;
    }
}