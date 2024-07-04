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
            Map<Integer, Integer> rowCount = new HashMap<>();
            Map<Integer, Integer> colCount = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String[] coordinates = reader.readLine().split(" ");
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);
                
                rowCount.merge(row, 1, Integer::sum);
                colCount.merge(col, 1, Integer::sum);
            }
            
            int maxRow = calculateMax(rowCount);
            int maxCol = calculateMax(colCount);
            
            System.out.println("Case #" + testCase + ": " + Math.max(maxRow, maxCol));
        }
    }

    private static int calculateMax(Map<Integer, Integer> countMap) {
        int sum = 0;
        int oddCount = 0;
        int singleCount = 0;
        boolean hasSixOrMore = false;
        
        for (int count : countMap.values()) {
            if (count >= 6) {
                hasSixOrMore = true;
            }
            if (count == 1) {
                singleCount++;
            } else if (count % 2 == 0) {
                sum += count;
            } else {
                sum += count - 1;
                oddCount++;
            }
        }

        if (!hasSixOrMore && oddCount % 2 == 1) {
            oddCount--;
            singleCount++;
        }

        return sum + Math.min(singleCount, 2) + oddCount;
    }
}