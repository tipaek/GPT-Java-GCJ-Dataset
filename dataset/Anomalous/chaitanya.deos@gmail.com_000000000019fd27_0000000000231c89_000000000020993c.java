import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")))) {
            while (scanner.hasNext()) {
                int T = scanner.nextInt();
                for (int i = 0; i < T; i++) {
                    int N = scanner.nextInt();
                    int[][] matrix = new int[N][N];
                    int traceSum = 0;
                    int dupRowCount = 0;
                    
                    for (int row = 0; row < N; row++) {
                        Set<Integer> rowSet = new HashSet<>();
                        boolean rowHasDuplicate = false;
                        
                        for (int col = 0; col < N; col++) {
                            matrix[row][col] = scanner.nextInt();
                            if (row == col) {
                                traceSum += matrix[row][col];
                            }
                            if (!rowHasDuplicate && !rowSet.add(matrix[row][col])) {
                                rowHasDuplicate = true;
                                dupRowCount++;
                            }
                        }
                    }
                    
                    int dupColCount = 0;
                    for (int col = 0; col < N; col++) {
                        Set<Integer> colSet = new HashSet<>();
                        boolean colHasDuplicate = false;
                        
                        for (int row = 0; row < N; row++) {
                            if (!colHasDuplicate && !colSet.add(matrix[row][col])) {
                                colHasDuplicate = true;
                                dupColCount++;
                            }
                        }
                    }
                    
                    System.out.printf("Case #%d: %d %d %d%n", (i + 1), traceSum, dupRowCount, dupColCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}