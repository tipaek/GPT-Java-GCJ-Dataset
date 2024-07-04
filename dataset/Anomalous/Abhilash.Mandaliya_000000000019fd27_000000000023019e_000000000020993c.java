import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>(n);
                boolean rowDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowDuplicate) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowRepeats++;
                            rowDuplicate = true;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>(n);
                boolean colDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colDuplicate) {
                        if (colSet.contains(matrix[i][j])) {
                            colRepeats++;
                            colDuplicate = true;
                        } else {
                            colSet.add(matrix[i][j]);
                        }
                    }
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}