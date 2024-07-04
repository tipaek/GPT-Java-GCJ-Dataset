import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepetitions = 0, colRepetitions = 0;
            
            int[][] matrix = new int[n][n];
            Set<Integer>[] columnSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    columnSets[j].add(value);
                    
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() < n) {
                    rowRepetitions++;
                }
            }

            for (Set<Integer> colSet : columnSets) {
                if (colSet.size() < n) {
                    colRepetitions++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
        
        scanner.close();
    }
}