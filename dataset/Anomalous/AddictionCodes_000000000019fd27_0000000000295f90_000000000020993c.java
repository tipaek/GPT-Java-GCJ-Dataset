import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean rowValid = true;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    
                    if (!rowSet.add(matrix[i][j])) {
                        rowValid = false;
                    }
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                
                if (!rowValid) {
                    rowDuplicates++;
                }
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colValid = true;
                
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colValid = false;
                    }
                }
                
                if (!colValid) {
                    colDuplicates++;
                }
            }
            
            writer.write(String.format("Case #%d: %d %d %d%n", testCase, trace, rowDuplicates, colDuplicates));
        }
        
        writer.flush();
    }
}