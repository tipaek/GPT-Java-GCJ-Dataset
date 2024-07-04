
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int size = in.nextInt();
            int sum = 0;
            int columns = 0;
            int rows = 0;
            Map<String, Integer> columnValues = new HashMap<>();
            for (int y = 0; y < size; y++) {
                Map<String, Integer> rowValues = new HashMap<>();
                for (int x = 0; x < size; x++) {
                    Integer value = in.nextInt();
                    String columnKey = x + "_" + value;
                    String rowKey = String.valueOf(value);
                    if (!rowValues.containsKey(rowKey)) {
                        rowValues.put(rowKey, 1);
                    } else {
                        rowValues.put(rowKey, rowValues.get(rowKey) + 1);
                    }
                    if (!columnValues.containsKey(columnKey)) {
                        columnValues.put(columnKey, 1);
                    } else {
                        columnValues.put(columnKey, columnValues.get(columnKey) + 1);
                    }
                    if (x == y) {
                        sum += value;
                    }
                }
                for (Integer count : rowValues.values()) {
                    if (count > 1) {
                        rows++;
                        break;
                    }
                }
            }
            Map<String, Boolean> usedColumns = new HashMap<>();
            for (String key : columnValues.keySet()) {
                Integer count = columnValues.get(key);
                if (count > 1 && !usedColumns.containsKey(key.split("_")[0])) {
                    columns++;
                    usedColumns.put(key.split("_")[0], true);
                }
                
            }
            System.out.println("Case #" + c + ": " + sum + " " + rows + " " + columns);
        }
    }
}
