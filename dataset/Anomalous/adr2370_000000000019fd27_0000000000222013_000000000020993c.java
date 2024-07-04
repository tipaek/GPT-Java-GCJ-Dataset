package app;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[N][N];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            // Check for duplicate elements in rows
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in columns
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, trace, duplicateRows, duplicateColumns);
        }
    }
}