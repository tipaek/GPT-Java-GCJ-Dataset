import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            List<Set<Integer>> columns = new ArrayList<>();
            List<Set<Integer>> rows = new ArrayList<>();
            
            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
                rows.add(new HashSet<>());
            }
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    columns.get(j).add(value);
                    rows.get(i).add(value);
                }
            }
            
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (rows.get(i).size() != matrixSize) {
                    rowDuplicates++;
                }
                if (columns.get(i).size() != matrixSize) {
                    columnDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
        scanner.close();
    }
}