import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<List<Integer>> matrix = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                String[] values = reader.readLine().split(" ");
                for (String value : values) {
                    row.add(Integer.parseInt(value));
                }
                matrix.add(row);
            }
            
            int trace = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                trace += matrix.get(i).get(i);
                
                Set<Integer> rowSet = new HashSet<>(matrix.get(i));
                if (rowSet.size() < n) {
                    rowsWithDuplicates++;
                }
                
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix.get(j).get(i));
                }
                if (colSet.size() < n) {
                    colsWithDuplicates++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowsWithDuplicates, colsWithDuplicates);
        }
    }
}